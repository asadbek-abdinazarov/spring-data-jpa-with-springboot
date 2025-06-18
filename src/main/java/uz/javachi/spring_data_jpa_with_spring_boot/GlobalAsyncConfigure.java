package uz.javachi.spring_data_jpa_with_spring_boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

@Slf4j
@Configuration
public class GlobalAsyncConfigure implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error("Error : On method {}, Input params: {}", method.getName(), params);
            ex.printStackTrace();
        };
    }
}


