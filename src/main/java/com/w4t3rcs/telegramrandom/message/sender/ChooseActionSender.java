package com.w4t3rcs.telegramrandom.message.sender;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.util.ButtonHelper;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public class ChooseActionSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (!update.hasCallbackQuery() || (update.hasCallbackQuery() && ("userinfo_btn".equals(update.getCallbackQuery().getData()) || "need_response".equals(update.getCallbackQuery().getData())))) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend("Choose your option!");
            ButtonHelper buttonHelper = chatHelper.getButtonHelper();
            buttonHelper.attachButtons(messageToSend, Map.of(
                    "Get User Info", "userinfo_btn",
                    "Start Quiz", "starttest_btn"
            ));

            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
