package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.enums.ScoreEnum;


public class TennisGame2 extends AbstractTennisGame implements TennisGame {

    public TennisGame2(String player1Name, String player2Name) {
        super(player1Name,player2Name);
    }

    public String getScore() {

        if (isEqualScore()) {
            if (score_1 < 3) {
                return ScoreEnum.of(score_1).getDesc() + "-All";
            }
            return "Deuce";
        }

        if (Math.abs(score_1 - score_2) < 2 && Math.min(score_1,score_2) >= 3){
            return "Advantage " + (score_1 > score_2 ? player1Name : player2Name);
        }

        if (Math.abs(score_1 - score_2) >= 2 && Math.max(score_1,score_2) >= 4){
            return "Win for " + (score_1 > score_2 ? player1Name : player2Name);
        }

        return ScoreEnum.of(score_1).getDesc() + "-" + ScoreEnum.of(score_2).getDesc();
    }


}