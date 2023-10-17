package com.w4t3rcs.telegramrandom.message.sender.quiz;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.sender.Sender;
import com.w4t3rcs.telegramrandom.message.util.ButtonHelper;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public class FavouriteAnimalSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData().contains("color")) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend("Second question!\nWhat is your favourite animal?");
            ButtonHelper buttonHelper = chatHelper.getButtonHelper();
            buttonHelper.attachButtons(messageToSend, Map.of(
                    "\uD83D\uDC08", "cat_animal_btn",
                    "\uD83D\uDC15", "dog_animal_btn",
                    "\uD83D\uDC0E", "horse_animal_btn",
                    "\uD83D\uDD4A", "bird_animal_btn",
                    "\uD83D\uDC20", "fish_animal_btn",
                    "\uD83D\uDC0D", "snake_animal_btn"
            ));

            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
