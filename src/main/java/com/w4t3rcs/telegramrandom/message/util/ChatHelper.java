package com.w4t3rcs.telegramrandom.message.util;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Data
public class ChatHelper {
    private final SendMessageHelper sendMessageHelper;
    private final ButtonHelper buttonHelper;

    public Long getChatId(Update update) {
        if (update.hasMessage()) return update.getMessage().getChatId();
        else if (update.hasCallbackQuery()) return update.getCallbackQuery().getFrom().getId();
        else return null;
    }
}
