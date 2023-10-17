package com.w4t3rcs.telegramrandom.message.sender.quiz.executor;

import com.w4t3rcs.telegramrandom.message.sender.quiz.ScoreContainer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TimeTestExecutor implements TestExecutor {
    public void execute(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.contains("time")) {
                switch (data) {
                    case "day_time_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 4);
                    case "night_time_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 7);
                }
            }
        }
    }
}
