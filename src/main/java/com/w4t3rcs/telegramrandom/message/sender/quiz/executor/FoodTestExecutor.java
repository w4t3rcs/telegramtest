package com.w4t3rcs.telegramrandom.message.sender.quiz.executor;

import com.w4t3rcs.telegramrandom.message.sender.quiz.ScoreContainer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FoodTestExecutor implements TestExecutor {
    public void execute(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            if (data.contains("food")) {
                switch (data) {
                    case "salad_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 1);
                    case "fruit_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 2);
                    case "burger_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 3);
                    case "cake_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 4);
                    case "taco_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 5);
                    case "pizza_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 6);
                    case "sushi_food_btn" -> ScoreContainer.setScore(ScoreContainer.getScore() + 7);
                }
            }
        }
    }
}
