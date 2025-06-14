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

@SqlResultSetMapping(
        name = "PostDtoMapping",
        classes = @ConstructorResult(
                targetClass = IPosDtoTwo.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "title", type = String.class)
                }
        )
)
@NamedNativeQuery(name = "Post.getOnlyIdAndTitle", resultSetMapping = "PostDtoMapping", query = "select p.id, p.title from post p")

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
