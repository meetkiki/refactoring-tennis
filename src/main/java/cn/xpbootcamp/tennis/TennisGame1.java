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
        StringBuilder score = new StringBuilder();

        if (m_score1 == m_score2) {
            if (m_score1 > 2){
                score = new StringBuilder("Deuce");
            }else {
                score = score.append(ScoreEnum.of(m_score1).getDesc()).append("-All");
            }
            return score.toString();
        }

        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) score = new StringBuilder("Advantage player1");
            else if (minusResult == -1) score = new StringBuilder("Advantage player2");
            else if (minusResult >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
            return score.toString();
        }

        for (int i = 1, tempScore; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                score.append("-");
                tempScore = m_score2;
            }
            score.append(ScoreEnum.of(tempScore).getDesc());
        }
        return score.toString();
    }
}