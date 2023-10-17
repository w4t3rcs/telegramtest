package com.w4t3rcs.telegramrandom.message.sender.quiz.executor;

import com.w4t3rcs.telegramrandom.message.sender.quiz.ScoreContainer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ColorTestExecutor implements TestExecutor {
    public void execute(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.contains("color")) {
                switch (data) {
                    case "red_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 1);
                    case "blue_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 2);
                    case "green_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 3);
                    case "purple_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 4);
                    case "yellow_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 5);
                    case "white_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 6);
                    case "black_color_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 7);
                }
            }
        }
    }
}
