package com.example.brocker_services_back_end.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonneDto {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
}
