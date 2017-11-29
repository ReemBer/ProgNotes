package by.bsuir.prognotes.repository;

import by.bsuir.prognotes.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 29.11.2017 18:06
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
