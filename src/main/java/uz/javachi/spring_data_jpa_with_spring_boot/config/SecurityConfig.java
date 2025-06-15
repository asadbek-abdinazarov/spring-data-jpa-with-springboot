package uz.javachi.spring_data_jpa_with_spring_boot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import uz.javachi.spring_data_jpa_with_spring_boot.dtos.ErrorDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, ObjectMapper objectMapper) throws Exception {
        http
                .cors(configurer -> {
                            configurer.configurationSource(corsConfigurationSource());
                            configurer.configure(http);
                        }
                )
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling((ex) ->
                        {
                            ex.authenticationEntryPoint(authenticationEntryPoint(objectMapper));
                            ex.accessDeniedHandler(accessDeniedHandler(objectMapper));
                        }
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        List<UserDetails> users = new ArrayList<>() {{
            add(User.builder()
                    .username("admin")
                    .password(passwordEncoder().encode("admin"))
                    .roles("ADMIN")
                    .build());
            add(User.builder()
                    .username("user")
                    .password(passwordEncoder().encode("user"))
                    .roles("USER")
                    .build());
            add(User.builder()
                    .username("manager")
                    .password(passwordEncoder().encode("manager"))
                    .roles("MANAGER")
                    .build());
        }};

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(ObjectMapper objectMapper) {
        return (request,
                response,
                authException) -> {
            String errorURI = request.getRequestURI();
            String errorMessage = authException.getMessage();
            int errorCode = 401;
            log.warn("Error URI: {}, Msg: {}, Code: {}", errorURI, errorMessage, errorCode);

            ErrorDto errorDto = new ErrorDto(errorURI, errorMessage, errorCode);
            response.setStatus(errorCode);

            objectMapper.writeValue(response.getOutputStream(), errorDto);
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(ObjectMapper objectMapper) {
        return (request, response, accessDeniedException) -> {
            String errorURI = request.getRequestURI();
            String errorMessage = accessDeniedException.getMessage();
            int errorCode = 403;
            log.warn("Error URI: {}, Msg: {}, Code: {}", errorURI, errorMessage, errorCode);

            ErrorDto errorDto = new ErrorDto(errorURI, errorMessage, errorCode);
            response.setStatus(errorCode);

            objectMapper.writeValue(response.getOutputStream(), errorDto);
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(
                List.of(
                        "http://localhost:8081",
                        "http://localhost:8082",
                        "http://localhost:8083"
                )
        );
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/v1/**", configuration);
        return source;
    }
}
