package com.example.brocker_services_back_end.Enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Service {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String nom;
    private String img;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employe> employes;
}
