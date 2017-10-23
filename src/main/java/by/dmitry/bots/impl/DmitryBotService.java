package by.dmitry.bots.impl;

import by.dmitry.bots.contstants.BotContstants.BotAnswerMessages;
import by.dmitry.bots.contstants.BotContstants.Configs;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created def327 on 10/23/17.
 */
@Service("dmitryBot")
public class DmitryBotService
        extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help"))
                sendMsg(message, BotAnswerMessages.GREETING_MESSAGE);
            else
                sendMsg(message, BotAnswerMessages.REGARDS_MESSAGE);
        }
    }

    public String getBotUsername() {
        return Configs.BOT_NAME;
    }

    public String getBotToken() {
        return Configs.BOT_TOKEN;
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}