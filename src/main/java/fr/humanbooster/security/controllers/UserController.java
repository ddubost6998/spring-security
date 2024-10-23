package fr.humanbooster.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.humanbooster.security.model.FakeUser;
import fr.humanbooster.security.services.UserService;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RolesAllowed({"ADMIN"})
    public List<FakeUser> getAllUsers() {
        return userService.getAllUsers();
    }
}