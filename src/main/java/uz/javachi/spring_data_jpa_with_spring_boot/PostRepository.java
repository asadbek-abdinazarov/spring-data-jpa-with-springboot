package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}