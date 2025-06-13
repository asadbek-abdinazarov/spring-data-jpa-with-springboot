package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
@NamedQuery(name = "Post.getAllPostsByUserId", query = "from Post where userId = ?1")
@NamedNativeQuery(name = "Post.getAllPostsByUserIdNative", resultClass = Post.class, query = "select * from post p where p.user_id = ?1")
public class Post {
    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;
}
