package by.dmitry.bots.contstants;

/**
 * Created def327 on 10/23/17.
 */
public interface BotContstants {

    interface Configs {
        String BOT_NAME = "";
        String BOT_TOKEN = "";
    }

    interface BotAnswerMessages {
        String GREETING_MESSAGE = "Hello Dmitry!";
        String REGARDS_MESSAGE = "Dmitry,Have a good day!";
    }

    interface ApplicationConfig {
        String BOT_BEAN = "dmitryBot";
        String APPLICATION_CONTEXT_XML_NAME = "application-context.xml";
    }
}