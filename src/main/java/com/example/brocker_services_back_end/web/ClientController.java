package com.example.brocker_services_back_end.web;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @GetMapping("/clients/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ClientDto getClient(@PathVariable(name = "id") long id){
        return clientService.getClient(id);
    }
    @GetMapping("/clients")
    public List<ClientDto> getClients(){
        return clientService.getClients();
    }
    @PostMapping("/clients/add")
    public ClientDto addClient(@RequestBody ClientDto clientDto){
        return clientService.ajouterClient(clientDto);
    }
    @PutMapping("/clients/Edit/{id}")
    public ClientDto editClient(@PathVariable long id,@RequestBody ClientDto clientDto){
        clientDto.setId(id);
        return clientService.modifierClient(clientDto);
    }
    @DeleteMapping("/clients/Delete/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.supprimerClient(id);
    }
}
