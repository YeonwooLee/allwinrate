package jyanoos.lol_bottom.domain.recommend;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RecommendAdcKnowEadcEsup implements Comparable<RecommendAdcKnowEadcEsup>{
    String mAdc; //임의의 원딜
    String eSup; //입력받은 적서폿
    String eAdc; //입력받은 적원딜
    String mAdcE; //임의의 원딜
    String eSupE; //입력받은 적서폿
    String eAdcE; //입력받은 적원딜

    int whole;
    int win;
    float winrate;//임의의원딜_입력받은서폿 조합의 승률

    public RecommendAdcKnowEadcEsup(int whole, int win, float winrate) {
        this.whole = whole;
        this.win = win;
        this.winrate =winrate;
    }

    @Override
    public int compareTo(RecommendAdcKnowEadcEsup o) {
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

