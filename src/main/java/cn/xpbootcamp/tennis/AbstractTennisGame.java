package cn.xpbootcamp.tennis;

import java.util.Objects;

public abstract class AbstractTennisGame {

    protected static final String PLAYER1 = "player1";
    protected static final String PLAYER2 = "player2";

    protected int score_1 = 0;
    protected int score_2 = 0;

    protected String player1Name;
    protected String player2Name;


    public AbstractTennisGame(String player1Name,String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    protected boolean isEqualScore() {
        return this.score_1 == this.score_2;
    }


    protected boolean isScoreExceedsFour() {
        return score_1 >= 4 || score_2 >= 4;
    }


    public void wonPoint(String player) {
        if (Objects.equals(player, "player1")) {
            score_1++;
        } else {
            score_2++;
        }
    }
}
