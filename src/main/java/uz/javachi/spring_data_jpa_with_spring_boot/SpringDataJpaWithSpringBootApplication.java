package uz.javachi.spring_data_jpa_with_spring_boot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Comment;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Post;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Todo;
import uz.javachi.spring_data_jpa_with_spring_boot.repositories.CommentRepository;
import uz.javachi.spring_data_jpa_with_spring_boot.repositories.PostRepository;
import uz.javachi.spring_data_jpa_with_spring_boot.repositories.TodoRepository;

import java.net.URI;
import java.util.List;

/*@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "${api.version}",
                contact = @Contact(
                        name = "Asadbek Abdinazarov",
                        email = "asadbekabdinazarov601@gmail.com",
                        url = "https://github.com/asadbek-abdinazarov"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application",
                summary = "This is summary",
                extensions = {
                        @Extension(
                                name = "x-custom-info",
                                properties = {
                                        @ExtensionProperty(name = "author", value = "Oshna"),
                                        @ExtensionProperty(name = "version", value = "1.0", parseValue = true)
                                }
                        )
                }
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation",
                url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)*/
@Slf4j
@SpringBootApplication
public class SpringDataJpaWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaWithSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PostRepository postRepository,
            CommentRepository commentRepository,
            TodoRepository todoRepository,
            ObjectMapper objectMapper
    ) {
        return args -> {

            URI commentUri = URI.create("https://jsonplaceholder.typicode.com/comments");

            URI postUri = URI.create("https://jsonplaceholder.typicode.com/posts");

            URI todoUri = URI.create("https://jsonplaceholder.typicode.com/todos");

            List<Comment> commentsList = objectMapper.readValue(commentUri.toURL(), new TypeReference<>() {
            });
            log.info("Comments loaded to list size is : {}", commentsList.size());

            List<Post> postsList = objectMapper.readValue(postUri.toURL(), new TypeReference<>() {
            });
            log.info("Posts loaded to list size is : {}", postsList.size());

            List<Todo> todosList = objectMapper.readValue(todoUri.toURL(), new TypeReference<>() {
            });
            log.info("Todos loaded to list size is : {}", todosList.size());


            commentRepository.saveAll(commentsList);

            postRepository.saveAll(postsList);

            todoRepository.saveAll(todosList);

            log.info("All data are saved to H2 database!");
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };

    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("${api.version}")
                        .contact(new Contact()
                                .name("Asadbek Abdinazarov")
                                .email("asadbekabdinazarov01@gmail.com")
                                .url("https://github.com/asadbek-abdinazarov"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Production"),
                        new Server()
                                .url("http://localhost:9090")
                                .description("Test")
                ))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth", "bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .name("basicAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic"))
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                );

    }

    @Bean
    public GroupedOpenApi annotationGroupAPI() {
        return GroupedOpenApi.builder()
                .group("Most useful API")
                .pathsToMatch("/api/todos/**", "/api/posts/**")
                .build();
    }
}
