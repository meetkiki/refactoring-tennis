package cn.xpbootcamp.tennis.enums;

import java.util.Arrays;


public enum ScoreEnum {

    Love(0,"Love"),
    Fifteen(1,"Fifteen"),
    Thirty(2,"Thirty"),
    Forty(3,"Forty");
    private int score;
    private String desc;

    ScoreEnum(int score, String desc) {
        this.score = score;
        this.desc = desc;
    }

    public static ScoreEnum of(int score) {
        return Arrays.stream(ScoreEnum.values())
                .filter(scoreEnum -> scoreEnum.score == score)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported parameters " + score));
    }

    public int getScore() {
        return score;
    }

    public String getDesc() {
        return desc;
    }

}
