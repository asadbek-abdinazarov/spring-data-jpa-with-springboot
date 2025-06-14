package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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

//    @Query(value = "from Post")
    @Query(nativeQuery = true,
            value = "select * from post",
            countQuery =  "select count(*) from post")
    Page<Post> getAllPageable(Pageable pageable);

    List<Post> id(Integer id);

    @Query(value = "from Post where userId in (?1)")
    List<Post> getAllPostsByUserIds(Collection<Integer> ids);

    @Modifying
    @Transactional
    @Query(value = "delete Post p where p.userId = ?1")
    void deletePostByUserId(Integer userId);
}
