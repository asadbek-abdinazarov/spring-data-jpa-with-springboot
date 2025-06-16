package uz.javachi.spring_data_jpa_with_spring_boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    private Integer id;
    private Integer postId;
    private String name;
    private String email;

    @Column(length = 2500)
    private String body;
}

