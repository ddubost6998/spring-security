package fr.humanbooster.security.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.humanbooster.security.model.FakeUser;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<FakeUser> users;

    public UserService(PasswordEncoder passwordEncoder) {
        this.users = List.of(
                new FakeUser("user", passwordEncoder.encode("user")),
                new FakeUser("admin", passwordEncoder.encode("admin"))
        );
    }

    public Optional<FakeUser> getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public List<FakeUser> getAllUsers() {
        return users;
    }
}
