package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDataJpaWithSpringBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);

    }


}
