package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.OutputStream;
import java.net.URI;

@SpringBootApplication
@EnableAsync
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
        String encoded = org.h2.server.web.WebServer.encodeAdminPassword("sdfsdfkskdfksdf");
        System.out.println(encoded);
    }
/*
    @Bean
    @Profile("dev")
    public TaskExecutor taskExecutorDev() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setKeepAliveSeconds(10);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("dev-");
        executor.initialize();
        return executor;
    }

    @Bean
    @Profile("test")
    public TaskExecutor taskExecutorTest() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setKeepAliveSeconds(15);
        executor.setQueueCapacity(40);
        executor.setThreadNamePrefix("test-");
        executor.initialize();
        return executor;
    }

    @Bean
    @Profile("prod")
    public TaskExecutor taskExecutorProd() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("prod-");
        executor.initialize();
        return executor;
    }*/

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            URI uri = URI.create("http://localhost:8080/");
        };
    }
}
