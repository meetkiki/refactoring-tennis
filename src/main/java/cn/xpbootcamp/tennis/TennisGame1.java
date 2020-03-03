package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.enums.ScoreEnum;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
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
        int minusResult = m_score1 - m_score2;
        if (Math.abs(minusResult) == 1) {
            return "Advantage " + (m_score1 > m_score2 ? "player1" : "player2");
        }
        return "Win for " + (m_score1 > m_score2 ? "player1" : "player2");
    }


    private String unbeatenOrdinary() {
        StringBuilder score = new StringBuilder();
        score.append(ScoreEnum.of(m_score1).getDesc())
                .append("-")
                .append(ScoreEnum.of(m_score2).getDesc());
        return score.toString();
    }

    private String sameScoreProcessing() {
        StringBuilder score = new StringBuilder();
        if (this.m_score1 > 2) {
            score = new StringBuilder("Deuce");
            return score.toString();
        }
        score.append(ScoreEnum.of(this.m_score1).getDesc()).append("-All");
        return score.toString();
    }

    private boolean isScoreExceedsFour() {
        return m_score1 >= 4 || m_score2 >= 4;
    }


    private boolean isEqualScore() {
        return this.m_score1 == this.m_score2;
    }
}