package jyanoos.lol_bottom.service;

import jyanoos.lol_bottom.domain.AllWinrate;
import jyanoos.lol_bottom.domain.CombiReply;
import jyanoos.lol_bottom.domain.CombiReplyBoard;
import jyanoos.lol_bottom.lolSetting.LolSetting;
import jyanoos.lol_bottom.mapper.AllWinrateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AllWinrateServiceImpl implements AllWinrateService {
    private final AllWinrateMapper allWinrateMapper;
    private final LolSetting lolSetting;

    @Override
    public List<AllWinrate> mkAllWinrateList(int minPansoo,int lenList) throws IOException {
        //조합별 총승률 리스트 가져옴
        List<AllWinrate> allWinrateList = allWinrateMapper.allWinrateList();

        //판수 minPansoo 이하인 애들 제거
        for(Iterator<AllWinrate> iterator = allWinrateList.iterator(); iterator.hasNext();){
            AllWinrate awr = iterator.next();
            if(awr.getWhole()<minPansoo){
                iterator.remove();
            }
            awr.setEngAdc(lolSetting.convertKoToEng(awr.getAdc()));
            awr.setEngSup(lolSetting.convertKoToEng(awr.getSup()));

        }

        //정렬(1기준 승률, 2기준 판수)
        Collections.sort(allWinrateList);
        
        //상위n개만 리턴
        allWinrateList = allWinrateList.subList(0,lenList);
        return allWinrateList;
    }

    @Override
    public CombiReplyBoard mkViewCombiBoard(AllWinrate allWinrate) {
        CombiReplyBoard combiReplyBoard = new CombiReplyBoard();
        String manager = "관리자";
        String mkBoardMessage = allWinrate.getAdc()+" & "+allWinrate.getSup()+" 조합 테이블이 생성되었습니다 :)";

        //adc_sup 테이블 있나 확인하고
        int exsistInt = allWinrateMapper.tblExist("lol_data",allWinrate.getEngAdc()+"_"+allWinrate.getEngAdc());
        //없으면
        if(exsistInt==0) {
            allWinrateMapper.createAwrTbl(allWinrate.getEngAdc(),allWinrate.getEngSup()); //만들고
            allWinrateMapper.writeAwlReply(allWinrate.getEngAdc(),allWinrate.getEngSup(),manager,mkBoardMessage); // 환영인사 남김
        }

        //해당 조합 게시판 댓글들
        List<CombiReply> replyList = allWinrateMapper.combiReplyList(allWinrate.getEngAdc(), allWinrate.getEngSup());

        combiReplyBoard.setAllWinrate(allWinrate);
        combiReplyBoard.setReplyList(replyList);

        return combiReplyBoard;
    }

}
