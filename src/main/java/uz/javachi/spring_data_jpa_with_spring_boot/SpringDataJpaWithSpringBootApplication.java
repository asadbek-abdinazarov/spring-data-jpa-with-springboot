package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PersonProperties.class)
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }
}
