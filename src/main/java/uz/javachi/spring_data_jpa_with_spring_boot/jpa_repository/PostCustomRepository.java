package uz.javachi.spring_data_jpa_with_spring_boot.jpa_repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class PostCustomRepository{

    private final EntityManager em;

    public PostCustomRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Post save(Post post) {
        em.persist(post);
        return post;
    }

}
