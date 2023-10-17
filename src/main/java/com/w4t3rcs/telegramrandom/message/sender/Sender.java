package com.w4t3rcs.telegramrandom.message.sender;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Sender {
    void sendScenario(TelegramBot telegramBot, Update update);
}
