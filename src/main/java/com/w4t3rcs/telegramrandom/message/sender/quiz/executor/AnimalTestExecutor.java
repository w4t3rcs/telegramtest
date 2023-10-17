package com.w4t3rcs.telegramrandom.message.sender.quiz.executor;

import com.w4t3rcs.telegramrandom.message.sender.quiz.ScoreContainer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AnimalTestExecutor implements TestExecutor {
    public void execute(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.contains("animal")) {
                switch (data) {
                    case "cat_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 1);
                    case "dog_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 3);
                    case "horse_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 4);
                    case "bird_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 5);
                    case "fish_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 6);
                    case "snake_animal_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 7);
                }
            }
        }
    }
}
