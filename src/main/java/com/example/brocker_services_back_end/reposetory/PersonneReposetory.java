package com.example.brocker_services_back_end.reposetory;

import com.example.brocker_services_back_end.Enteties.Client;
import com.example.brocker_services_back_end.Enteties.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneReposetory extends JpaRepository<Personne, Long> {
}
