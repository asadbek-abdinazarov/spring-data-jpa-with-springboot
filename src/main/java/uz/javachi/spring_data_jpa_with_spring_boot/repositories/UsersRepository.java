package uz.javachi.spring_data_jpa_with_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.javachi.spring_data_jpa_with_spring_boot.models.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findUsersByUsername(String username);
}