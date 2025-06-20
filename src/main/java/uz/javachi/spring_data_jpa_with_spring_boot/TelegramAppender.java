package uz.javachi.spring_data_jpa_with_spring_boot;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class TelegramAppender extends AppenderBase<LoggingEvent> {
    private final AbsSender absSender;

    public TelegramAppender() {
        addFilter(new Filter<>() {
            @Override
            public FilterReply decide(LoggingEvent loggingEvent) {
                return loggingEvent.getLevel().equals(Level.ERROR) ? FilterReply.ACCEPT : FilterReply.DENY;
            }
        });
        this.absSender = new BotConfiguration();
    }

    @SneakyThrows
    @Override
    protected void append(LoggingEvent loggingEvent) {
        String telegramMessage = loggingEvent.toString();
        String chatId = "1510894594";
        absSender.execute(SendMessage.builder()
                .chatId(chatId)
                .text(telegramMessage)
                .build());
    }
}
