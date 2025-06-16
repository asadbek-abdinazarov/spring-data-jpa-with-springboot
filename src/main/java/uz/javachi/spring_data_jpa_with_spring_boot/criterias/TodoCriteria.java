package uz.javachi.spring_data_jpa_with_spring_boot.criterias;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ParameterObject
public class TodoCriteria {

    private String title;
    private Type type;
    private Boolean completed;
    @Parameter(required = true, example = "2025-01-01")
    private LocalDate createdDate;
    @Parameter(required = true, example = "10")
    @Min(10)
    private Integer userId;

    public enum Type {
        EDUCATION,
        IT,
        SPORT
    }
}
