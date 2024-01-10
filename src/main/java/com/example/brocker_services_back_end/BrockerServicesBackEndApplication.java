package com.example.brocker_services_back_end;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Collectors;


@SpringBootApplication
@AllArgsConstructor
public class BrockerServicesBackEndApplication implements CommandLineRunner {
    ClientService clientService;
    public static void main(String[] args) {
        SpringApplication.run(BrockerServicesBackEndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ClientDto c = new ClientDto();
        c.setId(12);
        c.setNom("mohamed");
        c.setPrenom("echchebaby");
        for (int i = 0; i < 5; i++) {
            clientService.ajouterClient(c);
        }
        clientService.getClients().stream().map(cl->{
            System.out.println(cl.getId()+"-----"+cl.getNom()+"-----"+cl.getPrenom());
            return cl;
        }).collect(Collectors.toList());
    }
}
