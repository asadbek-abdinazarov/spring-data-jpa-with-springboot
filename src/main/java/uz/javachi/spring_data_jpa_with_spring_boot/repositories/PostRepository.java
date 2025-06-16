package uz.javachi.spring_data_jpa_with_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}