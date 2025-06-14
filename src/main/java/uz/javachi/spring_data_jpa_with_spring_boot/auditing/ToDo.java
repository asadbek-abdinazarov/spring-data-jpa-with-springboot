package uz.javachi.spring_data_jpa_with_spring_boot.auditing;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "todo")

@EntityListeners(AuditingEntityListener.class)
public class ToDo {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @LastModifiedBy
    private Long createdBy;
    @CreatedBy
    private Long updatedBy;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
