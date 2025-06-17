package uz.javachi.spring_data_jpa_with_spring_boot.dtos;

import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCreateDTO {
    private String title;
    private String body;
}
