package by.dmitry.bots.impl;

import by.dmitry.bots.api.BotInit;
import by.dmitry.bots.contstants.BotContstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 * Created def327 on 10/23/17.
 */
public class BotInitImpl implements BotInit {

    @Override
    public void initBot() {
        ApiContextInitializer.init();
        ApplicationContext context = new GenericXmlApplicationContext(BotContstants.ApplicationConfig.APPLICATION_CONTEXT_XML_NAME);
        DmitryBotService bot = (DmitryBotService) context.getBean(BotContstants.ApplicationConfig.BOT_BEAN);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public static BotInitImpl createBotInitImpl() {
        return new BotInitImpl();
    }
}