package uz.javachi.spring_data_jpa_with_spring_boot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository.Post;
import uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository.PostRepository;

import java.net.URI;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }

//    @Bean
    CommandLineRunner init(PostRepository repository,
                           ObjectMapper objectMapper) {
        return args -> {
            URI uri = URI.create("https://jsonplaceholder.typicode.com/posts");
            List<Post> posts = objectMapper.readValue(uri.toURL(), new TypeReference<>() {
            });
            repository.saveAll(posts);
        };
    }
}
