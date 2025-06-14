package uz.javachi.spring_data_jpa_with_spring_boot.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}