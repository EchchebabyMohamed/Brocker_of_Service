package com.example.brocker_services_back_end.Enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Client client;
    private String message;

}
