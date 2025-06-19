package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Properties;

@SpringBootApplication
@EnableAsync
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }

    /*@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        return mailSender;
    }*/
}
