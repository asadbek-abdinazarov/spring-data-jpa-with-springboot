package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Users;
import uz.javachi.spring_data_jpa_with_spring_boot.repositories.UsersRepository;

@SpringBootApplication
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }

//    @Bean
    CommandLineRunner init(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            usersRepository.save(
                    Users.builder()
                            .role("ADMIN")
                            .username("admin")
                            .password(passwordEncoder.encode("admin"))
                            .build()
            );
            usersRepository.save(
                    Users.builder()
                            .role("USER")
                            .username("user")
                            .password(passwordEncoder.encode("user"))
                            .build()
            );
            usersRepository.save(
                    Users.builder()
                            .role("MANAGER")
                            .username("manager")
                            .password(passwordEncoder.encode("manager"))
                            .build()
            );
        };
    }
}
