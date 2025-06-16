package uz.javachi.spring_data_jpa_with_spring_boot.models;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema(name = "Todo Entity",
        description = "This is Todo entity when you need to use this entity/model"
)
public class Todo {
    @Id
    private Integer id;
    @Parameter(name = "user id" , description = "Todo ni yaratgan odamning idsi", example = "1")
    private Integer userId;
    private String title;
    private boolean completed;
}