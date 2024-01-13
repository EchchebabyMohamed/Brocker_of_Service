package com.example.brocker_services_back_end.web;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@AllArgsConstructor
public class SecurityController {
    private AuthenticationManager authenticationManager;

    @GetMapping("/profile")
    public Authentication authenticationManager(Authentication authentication){
        return authentication;
    }
}
