package uz.javachi.spring_data_jpa_with_spring_boot.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "maqolalar", collectionResourceRel = "maqolalar")
public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<List<Post>> findByTitleStartsWithIgnoreCase(String title);
}