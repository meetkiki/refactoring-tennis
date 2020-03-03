package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.enums.ScoreEnum;

public class TennisGame1 extends AbstractTennisGame implements TennisGame {

    public TennisGame1(String player1Name, String player2Name) {
        super(player1Name,player2Name);
    }

    public String getScore() {
        if (isEqualScore()) {
            return sameScoreProcessing();
        }
        if (isScoreExceedsFour()) {
            return scoreExceedsFourProcess();
        }
        return unbeatenOrdinary();
    }

    private boolean isScoreExceedsFour() {
        return score_1 >= 4 || score_2 >= 4;
    }

    private String scoreExceedsFourProcess() {
        int minusResult = score_1 - score_2;
        if (Math.abs(minusResult) == 1) {
            return "Advantage " + (score_1 > score_2 ? player1Name : player2Name);
        }
        return "Win for " + (score_1 > score_2 ? player1Name : player2Name);
    }

    private String unbeatenOrdinary() {
        return ScoreEnum.of(score_1).getDesc() +
                "-" +
                ScoreEnum.of(score_2).getDesc();
    }

    private String sameScoreProcessing() {
        StringBuilder score = new StringBuilder();
        if (this.score_1 > 2) {
            score.append("Deuce");
            return score.toString();
        }
        score.append(ScoreEnum.of(this.score_1).getDesc()).append("-All");
        return score.toString();
    }


}