package jyanoos.lol_bottom.domain.recommend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RecommendCombiKnowEadcEsup implements Comparable<RecommendCombiKnowEadcEsup>{
    String mAdc; //임의의 원딜
    String mSup; //임의의 서폿
    String mCombi; //임의의 조합
    String eAdc; //입력받은 상대원딜
    String eSup; //입력받은 상대원딜
    String eCombi;//입력받은 상대조합

    String mAdcE; //임의의 원딜
    String mSupE; //임의의 서폿
    String mCombiE; //임의의 조합
    String eAdcE; //입력받은 상대원딜
    String eSupE; //입력받은 상대원딜
    String eCombiE;//입력받은 상대조합

    int whole;
    int win;
    float winrate;//임의의원딜_입력받은서폿 조합의 승률

    public RecommendCombiKnowEadcEsup(int whole, int win, float winrate) {
        this.whole = whole;
        this.win = win;
        this.winrate =winrate;
    }

    @Override
    public int compareTo(RecommendCombiKnowEadcEsup o) {
        //this쪽이 승률이 높다면 -1 리턴
        if(this.winrate>o.winrate){
            return -1;
            //승률 같으면 등장 수 많은게 위로
        }else if(this.winrate==o.winrate){
            if(this.whole>o.whole){
                return -1;
            }else if(this.whole==o.whole){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}