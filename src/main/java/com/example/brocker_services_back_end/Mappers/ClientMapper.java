package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.Enteties.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class ClientMapper {
    public Client clientDToToClient(ClientDto clientDto){
        Client client= new Client();
        BeanUtils.copyProperties(clientDto,client);
        return client;
    }

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto= new ClientDto();
        BeanUtils.copyProperties(client,clientDto);
        return clientDto;
    }
}
