package com.w4t3rcs.telegramrandom.message.sender.quiz.executor;

import com.w4t3rcs.telegramrandom.message.sender.quiz.ScoreContainer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HobbyTestExecutor implements TestExecutor {
    public void execute(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.contains("hobby")) {
                final int score = ScoreContainer.getScore();
                switch (data) {
                    case "sports_hobby_btn" -> ScoreContainer.setScore(score + 1);
                    case "music_hobby_btn" -> ScoreContainer.setScore(score + 2);
                    case "dance_hobby_btn" -> ScoreContainer.setScore(score + 3);
                    case "art_hobby_btn" -> ScoreContainer.setScore(score + 4);
                    case "computer_hobby_btn" -> ScoreContainer.setScore(score + 5);
                }

                callbackQuery.setData("need_response");
            }
        }
    }
}
