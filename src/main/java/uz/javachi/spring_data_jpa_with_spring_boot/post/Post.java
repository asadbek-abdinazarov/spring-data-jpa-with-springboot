package uz.javachi.spring_data_jpa_with_spring_boot.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

    @Id
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
