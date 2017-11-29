package by.bsuir.prognotes.repository;

import by.bsuir.prognotes.model.db.RegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 10.09.2017 21:35
 */
@Repository
public interface RegistrationDataRepository extends JpaRepository<RegistrationData, Long> {

    void deleteByExpirationTimeLessThan(Long currentTime);
    void deleteByUsername(String username);
    void deleteByEmail(String email);

    RegistrationData findByEmail(String email);
    RegistrationData findByUsername(String username);
    RegistrationData findByRegistrationHash(String registrationHash);
}
