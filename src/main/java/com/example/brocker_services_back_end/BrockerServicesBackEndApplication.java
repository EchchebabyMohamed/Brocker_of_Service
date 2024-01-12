package com.example.brocker_services_back_end;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.DTOs.ServiceDto;
import com.example.brocker_services_back_end.Services.ClientService;
import com.example.brocker_services_back_end.Services.EmployeService;
import com.example.brocker_services_back_end.Services.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
@AllArgsConstructor
public class BrockerServicesBackEndApplication implements CommandLineRunner {
    private ClientService clientService;
    private EmployeService employeService;
    private ServiceService serviceService;
    public static void main(String[] args) {
        SpringApplication.run(BrockerServicesBackEndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ClientDto c = new ClientDto();
        for (int i = 0; i < 5; i++) {
            c.setNom("Nom cl "+i);
            c.setPrenom("prenom cl "+i);
            clientService.ajouterClient(c);
        }
        EmployeDto employeDto = new EmployeDto();
        for (int i = 0; i < 10; i++) {
            employeDto.setNom("Nom emp "+i);
            employeDto.setPrenom("prenom emp "+i);
            employeService.ajouterEmploye(employeDto);
        }
        clientService.getClients().stream().map(cl->{
            System.out.println(cl.getId()+"-----"+cl.getNom()+"-----"+cl.getPrenom());
            return cl;
        }).collect(Collectors.toList());
        List<EmployeDto> collect =new ArrayList<>();
         collect = employeService.getEmployes().stream().map(cl -> {
            System.out.println(cl.getId() + "-----" + cl.getNom() + "-----" + cl.getPrenom());
            return cl;
        }).collect(Collectors.toList());

        //services
        System.out.println("-----------services----------");
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(12);
        serviceDto.setNom("hhhhhhhhhhhhh");
        serviceDto.getEmployeDtos().addAll(collect);
        ServiceDto serviceDto1 = serviceService.ajouterService(serviceDto);
//        System.out.println("-----------test enregistre services----------");
//        List<ServiceDto> servicesDtos = serviceService.getServices();
//        servicesDtos.forEach(serviceDto2 -> {
//            System.out.println(serviceDto2.getNom());
//            System.out.println("les employees de ce service");
//            serviceDto2.getEmployeDtos().forEach(em->{
//                System.out.println(em.getId() + "-----" + em.getNom() + "-----" + em.getPrenom());
//            });
//        });
    }
}
