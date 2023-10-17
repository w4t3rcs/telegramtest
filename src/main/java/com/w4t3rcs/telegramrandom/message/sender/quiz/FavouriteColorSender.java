package com.w4t3rcs.telegramrandom.message.sender.quiz;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.sender.Sender;
import com.w4t3rcs.telegramrandom.message.util.ButtonHelper;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public class FavouriteColorSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && "starttest_btn".equals(update.getCallbackQuery().getData())) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend("First question!\nWhat is your favourite color?");
            ButtonHelper buttonHelper = chatHelper.getButtonHelper();
            buttonHelper.attachButtons(messageToSend, Map.of(
                    "\uD83D\uDD34", "red_color_btn",
                    "\uD83D\uDD35", "blue_color_btn",
                    "\uD83D\uDFE2", "green_color_btn",
                    "\uD83D\uDFE3", "purple_color_btn",
                    "\uD83D\uDFE1", "yellow_color_btn",
                    "⚪", "white_color_btn",
                    "⚫", "black_color_btn"
            ));

            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
