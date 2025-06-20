package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringDataJpaWithSpringBootApplication {


    public static void main(String[] args) {
       /* class ClockTask extends TimerTask {

            private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

            @Override
            public void run() {
                System.out.println("\r" + "Time : " + dateFormat.format(new Date()));
            }
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ClockTask(), 4, 2);*/
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);

    }


}
