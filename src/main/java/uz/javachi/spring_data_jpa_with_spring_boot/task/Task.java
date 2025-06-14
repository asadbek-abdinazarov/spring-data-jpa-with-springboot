package uz.javachi.spring_data_jpa_with_spring_boot.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task", schema = "jpa_buddy")
public class Task {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Column(name = "name", nullable = false, length = 200)
    private String name;

}