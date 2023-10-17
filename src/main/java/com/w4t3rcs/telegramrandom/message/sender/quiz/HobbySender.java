package com.w4t3rcs.telegramrandom.message.sender.quiz;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.sender.Sender;
import com.w4t3rcs.telegramrandom.message.util.ButtonHelper;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public class HobbySender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData().contains("food")) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend("Fourth question!\nWhat is your hobby?");
            ButtonHelper buttonHelper = chatHelper.getButtonHelper();
            buttonHelper.attachButtons(messageToSend, Map.of(
                    "⚽", "sports_hobby_btn",
                    "\uD83C\uDFB5", "music_hobby_btn",
                    "\uD83D\uDDA5", "computer_hobby_btn",
                    "\uD83D\uDC83", "dance_hobby_btn",
                    "\uD83C\uDFA8", "art_hobby_btn"
            ));

            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
