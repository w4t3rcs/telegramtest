package com.w4t3rcs.telegramrandom.message.util;

import com.w4t3rcs.telegramrandom.message.TelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class SendMessageHelper {
    public CompletableFuture<Message> sendMessage(TelegramBot telegramBot, SendMessage message, Long chatId) {
        if (chatId != null) {
            message.setChatId(chatId);
            return sendMessage(telegramBot, message);
        } else {
            log.error("ChatId is null!");
            throw new RuntimeException();
        }
    }

    private <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> sendMessage(TelegramBot telegramBot, Method method) {
        return telegramBot.sendApiMethodAsync(method);
    }

    public SendMessage getMessageToSend(String text) {
        return getMessageToSend(text, StandardCharsets.UTF_8);
    }

    public SendMessage getMessageToSend(String text, Charset charset) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(new String(text.getBytes(), charset));
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        return sendMessage;
    }
}
