package com.w4t3rcs.telegramrandom.message.sender.quiz;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.sender.Sender;
import com.w4t3rcs.telegramrandom.message.util.ButtonHelper;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public class FavouriteFoodSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData().contains("time")) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend("Third question!\nWhat is your favourite food?");
            ButtonHelper buttonHelper = chatHelper.getButtonHelper();
            buttonHelper.attachButtons(messageToSend, Map.of(
                    "\uD83C\uDF4E", "fruit_food_btn",
                    "\uD83E\uDD6C", "salad_food_btn",
                    "\uD83C\uDF70", "cake_food_btn",
                    "\uD83C\uDF55", "pizza_food_btn",
                    "\uD83C\uDF2E", "taco_food_btn",
                    "\uD83C\uDF54", "burger_food_btn",
                    "\uD83C\uDF63", "sushi_food_btn"
            ));

            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }
}
