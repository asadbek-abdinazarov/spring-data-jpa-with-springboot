package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class BotConfiguration extends TelegramLongPollingBot {

    public BotConfiguration() {
        super("7897121337:AAH5ti905OEg-sMWpIhUwqzwbptvJDhQcaA");
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "OpenToWorkUzBot";
    }
}
