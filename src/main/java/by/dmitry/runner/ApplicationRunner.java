package by.dmitry.runner;

import by.dmitry.bots.api.BotInit;
import by.dmitry.bots.impl.BotInitImpl;

/**
 * Created def327 on 10/23/17.
 */
public class ApplicationRunner {


    public static void main(String[] args) {
        BotInit botInit = BotInitImpl.createBotInitImpl();
        botInit.initBot();
    }
}