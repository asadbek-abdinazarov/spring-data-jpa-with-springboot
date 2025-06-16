package uz.javachi.spring_data_jpa_with_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}