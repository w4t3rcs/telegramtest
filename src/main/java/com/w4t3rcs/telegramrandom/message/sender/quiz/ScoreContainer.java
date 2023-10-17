package com.w4t3rcs.telegramrandom.message.sender.quiz;

import lombok.Getter;

public class ScoreContainer {
    @Getter
    private static int score = 0;

    public static void setScore(int score) {
        ScoreContainer.score = score;
    }
}
