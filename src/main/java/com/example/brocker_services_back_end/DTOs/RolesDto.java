package com.example.brocker_services_back_end.DTOs;

import com.example.brocker_services_back_end.Enteties.Personne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class RolesDto {
    private String role;
}
