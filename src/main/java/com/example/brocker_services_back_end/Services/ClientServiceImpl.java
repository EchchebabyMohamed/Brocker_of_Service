package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.DemandeDto;
import com.example.brocker_services_back_end.Mappers.ClientMapper;
import com.example.brocker_services_back_end.Enteties.Client;
import com.example.brocker_services_back_end.Enteties.Personne;
import com.example.brocker_services_back_end.reposetory.ClientReposetory;
import com.example.brocker_services_back_end.reposetory.PersonneReposetory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    ClientReposetory clientReposetory;
    ClientMapper clientMapper;
    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = clientReposetory.findAll();
        List<ClientDto> clientDtos = clients.stream().map(cl->clientMapper
                .clientToClientDto(cl)).collect(Collectors.toList());
        return clientDtos;
    }

    @Override
    public ClientDto ajouterClient(ClientDto c) {
        ClientDto clientDto= new ClientDto();
        Client cl = clientReposetory.save(clientMapper.clientDToToClient(c));
        return clientMapper.clientToClientDto(cl);
    }

    @Override
    public ClientDto modifierClient(ClientDto c) {
        ClientDto clientDto= new ClientDto();
        Client cl = clientReposetory.save(clientMapper.clientDToToClient(c));
        return clientMapper.clientToClientDto(cl);
    }

    @Override
    public void supprimerClient(long id) {
        clientReposetory.deleteById(id);
    }

    @Override
    public DemandeDto demandeDeClient(long id) {
        return null;
    }
}
