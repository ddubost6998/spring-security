package fr.humanbooster.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.humanbooster.security.model.FakeUser;
import fr.humanbooster.security.repository.FakeUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final FakeUserRepository fakeUserRepository;

    public CustomUserDetailsService(FakeUserRepository fakeUserRepository) {
        this.fakeUserRepository = fakeUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<FakeUser> optionalUser = fakeUserRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found.");
        }

        FakeUser user = optionalUser.get();

        return new User(user.getUsername(), user.getPassword(), getRoles());
    }

    private List<GrantedAuthority> getRoles() {
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return roles;
    }
}
