package fr.humanbooster.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    @RolesAllowed({"USER", "ADMIN"})
    public String hello() {
        return "Hello Private";
    }
}