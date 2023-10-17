package com.w4t3rcs.telegramrandom.message.util;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ButtonHelper {
    public void attachButtons(SendMessage message, Map<String , String> buttons) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        buttons.forEach((keyboardName, keyboardValue) -> {
            InlineKeyboardButton keyboardButton = new InlineKeyboardButton();
            keyboardButton.setText(new String(keyboardName.getBytes(), StandardCharsets.UTF_8));
            keyboardButton.setCallbackData(keyboardValue);
            keyboard.add(List.of(keyboardButton));
        });

        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }
}
