package com.w4t3rcs.telegramrandom.message.sender;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class WelcomeSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend(String.format(
                    "Hello, dear %s!%nThis is a test bot with some really primitive functionality!",
                    update.getMessage().getFrom().getUserName()
            ));
            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
