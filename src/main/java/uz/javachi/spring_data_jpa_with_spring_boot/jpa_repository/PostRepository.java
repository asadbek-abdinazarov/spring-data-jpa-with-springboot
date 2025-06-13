package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {
    /*@Query(nativeQuery = true,
            value = "select * from post p where p.user_id = ?1")*/
//    @Query("from Post where userId = ?1")
    @Query(name = "Post.getAllPostsByUserIdNative", nativeQuery = true)
    List<Post> findAllByUserId(Integer userId);

    @Query(value = "from Post")
    List<Post> getAllPostsSortById(Sort sort);
}
