package com.example.brocker_services_back_end.Enteties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("CLI")
public class Client extends Personne{
    @ManyToMany(mappedBy = "clients")
    private List<Demande> demandes;
}