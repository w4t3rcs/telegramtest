package com.w4t3rcs.telegramrandom.message.sender.quiz;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import com.w4t3rcs.telegramrandom.message.sender.Sender;
import com.w4t3rcs.telegramrandom.message.util.ChatHelper;
import com.w4t3rcs.telegramrandom.message.util.SendMessageHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestResponseSender implements Sender {
    @Override
    public void sendScenario(TelegramBot telegramBot, Update update) {
        if (update.hasCallbackQuery() && "need_response".equals(update.getCallbackQuery().getData())) {
            ChatHelper chatHelper = telegramBot.getChatHelper();
            SendMessageHelper sendMessageHelper = chatHelper.getSendMessageHelper();
            String toFormat = "Your personality is: %s!%nYour score was: %s!";
            String formatElement = getFormatElement();
            SendMessage messageToSend = sendMessageHelper.getMessageToSend(String.format(toFormat, formatElement, ScoreContainer.getScore()));
            ScoreContainer.setScore(0);
            sendMessageHelper.sendMessage(telegramBot, messageToSend, chatHelper.getChatId(update));
        }
    }

    private static String getFormatElement() {
        String formatElement;
        int score = ScoreContainer.getScore();
        if (score <= 11) {
            formatElement = "\uD83E\uDDD1\u200D\uD83C\uDF93";
        } else if (score > 12 && score <= 18) {
            formatElement = "\uD83E\uDDD8\u200D♂️";
        } else if (score > 19 && score <= 23) {
            formatElement = "\uD83C\uDFC4\u200D♂️";
        } else if (score > 24 && score <= 29) {
            formatElement = "\uD83E\uDDD1\u200D\uD83C\uDFA8";
        } else {
            formatElement = "\uD83D\uDC68\u200D\uD83D\uDCBB";
        }

        return formatElement;
    }
}
