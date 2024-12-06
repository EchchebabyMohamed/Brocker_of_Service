package com.example.brocker_services_back_end.Enteties;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("EMP")
public class Employe extends Personne{
    private String img;
    private Float price;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Demande> demandes;
}
