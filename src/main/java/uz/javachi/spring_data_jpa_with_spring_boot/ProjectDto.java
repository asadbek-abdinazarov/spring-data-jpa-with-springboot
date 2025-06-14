package uz.javachi.spring_data_jpa_with_spring_boot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link Project}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto implements Serializable {
    private String name;
    @NotBlank(message = "code cannot be blank")
    private String code;

    private List<ProjectColumnDto> projectColumns = new ArrayList<>();
}