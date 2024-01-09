package com.example.brocker_services_back_end.reposetory;

import com.example.brocker_services_back_end.Enteties.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientReposetory extends JpaRepository<Client,Long> {

}
