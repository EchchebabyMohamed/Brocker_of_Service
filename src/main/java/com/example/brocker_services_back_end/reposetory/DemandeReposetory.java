package com.example.brocker_services_back_end.reposetory;

import com.example.brocker_services_back_end.Enteties.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeReposetory extends JpaRepository<Demande, Long> {
}
