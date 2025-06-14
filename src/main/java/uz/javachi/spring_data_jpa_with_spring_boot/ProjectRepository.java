package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Optional<Project> findByNameIgnoreCase(String name);

    @Query("select p from Project p where upper(p.name) = upper(?1)")
    Optional<Project> findByName(String name);

    @Query("select p from Project p where upper(p.name) = upper(?1)")
    List<Project> findAllByName(String name);
}