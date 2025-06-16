package uz.javachi.spring_data_jpa_with_spring_boot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Post {
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    @Column(length = 2500)
    private String body;
}
