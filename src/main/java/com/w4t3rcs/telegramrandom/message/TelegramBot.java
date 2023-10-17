package com.w4t3rcs.telegramrandom.message;

import com.w4t3rcs.telegramrandom.message.sender.ChooseActionSender;
import com.w4t3rcs.telegramrandom.message.sender.quiz.*;
import com.w4t3rcs.telegramrandom.message.sender.UserInfoSender;
import com.w4t3rcs.telegramrandom.message.sender.WelcomeSender;
import com.w4t3rcs.telegramrandom.message.sender.quiz.executor.*;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@Getter
@Setter
public class TelegramBot extends TelegramLongPollingBot {
    private static final String BOT_TOKEN = "6522979297:AAGJ6jeaKo1rqHub6By50HtoOoM9uxNHI1I";
    private final ChatHelper chatHelper;

    @Autowired
    public TelegramBot(ChatHelper chatHelper) {
        super(BOT_TOKEN);
        this.chatHelper = chatHelper;
    }

    @Override
    public void onUpdateReceived(Update update) {
        new WelcomeSender().sendScenario(this, update);
        new UserInfoSender().sendScenario(this, update);
        new FavouriteColorSender().sendScenario(this, update);
        new ColorTestExecutor().execute(update);
        new FavouriteAnimalSender().sendScenario(this, update);
        new AnimalTestExecutor().execute(update);
        new DayOrNightSender().sendScenario(this, update);
        new TimeTestExecutor().execute(update);
        new FavouriteFoodSender().sendScenario(this, update);
        new FoodTestExecutor().execute(update);
        new HobbySender().sendScenario(this, update);
        new HobbyTestExecutor().execute(update);
        new TestResponseSender().sendScenario(this, update);
        new ChooseActionSender().sendScenario(this, update);
    }

    @Override
    public String getBotUsername() {
        return "w4t3rcsJavaBot";
    }

    public <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> sendApiMethodAsync(Method method) {
        return super.sendApiMethodAsync(method);
    }
}
