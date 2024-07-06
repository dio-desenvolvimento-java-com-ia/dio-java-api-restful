package domain.model.repository;

import domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User, Long> {
}
