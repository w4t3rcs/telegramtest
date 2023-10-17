package com.w4t3rcs.telegramrandom.message.sender;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class UserInfoSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && "userinfo_btn".equals(update.getCallbackQuery().getData())) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            User user = update.getCallbackQuery().getFrom();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend(String.format(
                    "Username is: %s;%nFirst Name is: %s;%nLast Name is: %s;%nUser ID: %s;%nLanguage: %s;",
                    user.getUserName(), user.getFirstName(), user.getLastName(), user.getId(), user.getLanguageCode()
            ));
            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
