package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.DemandeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    public List<ClientDto> getClients();
    public ClientDto ajouterClient(ClientDto c);
    public ClientDto modifierClient(ClientDto c);
    public void supprimerClient(long id);
    public ClientDto getClient(long id);
}