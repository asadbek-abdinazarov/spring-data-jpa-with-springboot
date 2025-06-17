package uz.javachi.spring_data_jpa_with_spring_boot.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer id;
    private String title;
    private String body;
    private Integer viewCount;
    private Integer likeCount;
    private Integer dislikeCount;
    private Integer shareCount;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
