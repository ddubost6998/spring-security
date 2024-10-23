package fr.humanbooster.security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.humanbooster.security.services.TokenService;

@RestController
@RequestMapping("/public")
public class PublicController {

    private TokenService tokenService;

    public PublicController (TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping
    public String hello() {
        return "Hello Public";
    }

    @GetMapping("/login")
    public String login(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }
}
