package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.enums.ScoreEnum;

public class TennisGame3 extends AbstractTennisGame implements TennisGame {


    public TennisGame3(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    public String getScore() {
        String score;
        if (score_1 < 4 && score_2 < 4 && !(score_1 + score_2 == 6)) {
            score = ScoreEnum.of(score_1).getDesc();
            return (score_1 == score_2) ? score + "-All" : score + "-" + ScoreEnum.of(score_2).getDesc();
        }
        if (isEqualScore()){
            return "Deuce";
        }
        score = score_1 > score_2 ? player1Name : player2Name;
        return Math.abs(score_1 - score_2) == 1 ? "Advantage " + score : "Win for " + score;
    }

}