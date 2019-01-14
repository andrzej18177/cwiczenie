package pl.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hospital.entity.User;
import pl.hospital.entity.Patient;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(long userId);
    User findByLogin(String login);
    boolean existsByLogin(String login);
}
