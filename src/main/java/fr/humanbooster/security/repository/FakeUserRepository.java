package fr.humanbooster.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.humanbooster.security.model.FakeUser;

import java.util.Optional;

@Repository
public interface FakeUserRepository extends JpaRepository<FakeUser, Long> {
    
    Optional<FakeUser> findByUsername(String username);

}
