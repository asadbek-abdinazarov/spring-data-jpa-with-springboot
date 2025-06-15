package uz.javachi.spring_data_jpa_with_spring_boot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import uz.javachi.spring_data_jpa_with_spring_boot.post.Post;
import uz.javachi.spring_data_jpa_with_spring_boot.post.PostRepository;

import java.net.URI;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }


    @Bean
    CommandLineRunner run(ObjectMapper objectMapper, PostRepository postRepository) {
        return args -> {
            URI uri = URI.create("https://jsonplaceholder.typicode.com/posts");
            List<Post> post = objectMapper.readValue(uri.toURL(), new TypeReference<>() {
            });
            postRepository.saveAll(post);
        };
    }

    @Bean(name = "postPagedResourcesAssembler")
    public PagedResourcesAssembler<Post> postPagedResourcesAssembler() {
        return new PagedResourcesAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(), null);
    }

}
