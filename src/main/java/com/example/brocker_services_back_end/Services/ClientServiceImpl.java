package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.Exception.ClientNotFountException;
import com.example.brocker_services_back_end.Mappers.ClientMapper;
import com.example.brocker_services_back_end.Enteties.Client;
import com.example.brocker_services_back_end.Mappers.PersonneMapper;
import com.example.brocker_services_back_end.reposetory.ClientReposetory;
import com.example.brocker_services_back_end.reposetory.PersonneReposetory;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {
    ClientReposetory clientReposetory;
    ClientMapper clientMapper;
    PersonneReposetory personneReposetory;
    PersonneMapper personneMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = clientReposetory.findAll();
        List<ClientDto> clientDtos = clients.stream().map(cl->clientMapper
                .clientToClientDto(cl)).collect(Collectors.toList());
        return clientDtos;
    }

    @Override
    public ClientDto ajouterClient(ClientDto c) {
        c.setPassword(passwordEncoder.encode(c.getPassword()));
        ClientDto clientDto= new ClientDto();
        Client cl = clientReposetory.save(clientMapper.clientDToToClient(c));
        return clientMapper.clientToClientDto(cl);
    }

    @Override
    public ClientDto modifierClient(ClientDto c) {
        c.setPassword(passwordEncoder.encode(c.getPassword()));
        ClientDto clientDto= new ClientDto();
        Client cl = clientReposetory.save(clientMapper.clientDToToClient(c));
        return clientMapper.clientToClientDto(cl);
    }

    @Override
    public void supprimerClient(long id) {
        clientReposetory.deleteById(id);
    }
    @Override
    public ClientDto getClient(long id){
        Client client = clientReposetory.findById(id).orElseThrow(
                ()->new ClientNotFountException("Client non trouver")
        );
        return clientMapper.clientToClientDto(client);
    }
}