package me.dio.diojavaapirestfull.domain.repository;

import me.dio.diojavaapirestfull.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User, Long> {
//    * como fazer um join
    boolean existsByAccountNumber(String accountNumber);
}
