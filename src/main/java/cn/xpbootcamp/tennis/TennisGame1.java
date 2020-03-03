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

    private String scoreExceedsFourProcess() {
        int minusResult = score_1 - score_2;
        if (Math.abs(minusResult) == 1) {
            return "Advantage " + (score_1 > score_2 ? PLAYER1 : PLAYER2);
        }
        return "Win for " + (score_1 > score_2 ? PLAYER1 : PLAYER2);
    }

    private String unbeatenOrdinary() {
        StringBuilder score = new StringBuilder();
        score.append(ScoreEnum.of(score_1).getDesc())
                .append("-")
                .append(ScoreEnum.of(score_2).getDesc());
        return score.toString();
    }

    private String sameScoreProcessing() {
        StringBuilder score = new StringBuilder();
        if (this.score_1 > 2) {
            score = new StringBuilder("Deuce");
            return score.toString();
        }
        score.append(ScoreEnum.of(this.score_1).getDesc()).append("-All");
        return score.toString();
    }


}