package jyanoos.lol_bottom.service;



import jyanoos.lol_bottom.domain.FreeBoard;
import java.util.List;

public interface FreeBoardService {
    //테이블 유무 확인 있으면1 없으면0 리턴
    int isTblExist(String dBName, String tableName);

    //자유게시판 글 리스트 리턴
    List<FreeBoard> freeBoardList();

    //자유게시판 글 저장, 성공시 등록된 글 번호, 실패시0 리턴
    int writeFreeBoard(FreeBoard freeBoard);

    //글번호로 글 조회
    FreeBoard findByBno(int bno);

    //글번호로 제목, 내용, 작성자 수정, 성공시 수정된 글 번호, 실패시 0 리턴
    int updateFreeBoard(int bno, String title, String content, String writer);

    //글번호로 글 삭제
    boolean deleteByBno(int bno);
}