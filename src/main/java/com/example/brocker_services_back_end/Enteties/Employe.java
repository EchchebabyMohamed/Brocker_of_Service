package com.example.brocker_services_back_end.Enteties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("EMP")
public class Employe extends Personne{
    @ManyToMany(mappedBy = "employes", fetch = FetchType.LAZY)
    private List<Demande> demandes;
}
