package uz.javachi.spring_data_jpa_with_spring_boot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringDataJpaWithSpringBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);

    }

    @Configuration
     static class RegisterBot {

        private final BotConfiguration botConfig;

        RegisterBot(BotConfiguration botConfig) {
            this.botConfig = botConfig;
        }

        @EventListener(ContextRefreshedEvent.class)
        private void init() throws TelegramApiException {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(botConfig);
        }

        @PostConstruct
        public void run() {
            log.info("BOT ISHGA TUSHDI");
        }


        @PreDestroy
        public void destroy() {
            log.info("BOT ISHLASHDAN TO'XTADI");
        }
    }


}
