package com.example.brocker_services_back_end;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.DTOs.RolesDto;
import com.example.brocker_services_back_end.DTOs.ServiceDto;
import com.example.brocker_services_back_end.Exception.RoleExisteException;
import com.example.brocker_services_back_end.Services.ClientService;
import com.example.brocker_services_back_end.Services.EmployeService;
import com.example.brocker_services_back_end.Services.PersonneService;
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
    private PersonneService personneService;
    public static void main(String[] args) {
        SpringApplication.run(BrockerServicesBackEndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ClientDto c = new ClientDto();
//        personneService.addRole("ADMIN");
//        personneService.addRole("USER");
//
//        for (int i = 1; i < 6; i++) {
//            c.setNom("Nom cl "+i);
//            c.setPrenom("prenom cl "+i);
//            c.setEmail("mail"+i+"@gmail.com");
//            c.setPassword("12345");
//            clientService.ajouterClient(c);
//
//        }
//        try {
//            personneService.AddRoleToUser(1,"USER");
//            personneService.AddRoleToUser(1,"ADMIN");
//            personneService.AddRoleToUser(2,"USER");
//            personneService.AddRoleToUser(3,"ADMIN");
//            personneService.AddRoleToUser(3,"USER");
//        } catch (RoleExisteException e) {
//            throw new RuntimeException(e);
        }
//        //personneService.RemoveRoleToUser(3,"ADMIN");
//        EmployeDto employeDto = new EmployeDto();
//        for (int i = 0; i < 10; i++) {
//            employeDto.setNom("Nom emp "+i);
//            employeDto.setPrenom("prenom emp "+i);
//            employeService.ajouterEmploye(employeDto);
//        }
//        clientService.getClients().stream().map(cl->{
//            System.out.println(cl.getId()+"-----"+cl.getNom()+"-----"+cl.getPrenom());
//            return cl;
//        }).collect(Collectors.toList());
//        List<EmployeDto> collect =new ArrayList<>();
//         collect = employeService.getEmployes().stream().map(cl -> {
//            System.out.println(cl.getId() + "-----" + cl.getNom() + "-----" + cl.getPrenom());
//            return cl;
//        }).collect(Collectors.toList());

//        //services
//        System.out.println("-----------services----------");
//        ServiceDto serviceDto = new ServiceDto();
//        serviceDto.setId(12);
//        serviceDto.setNom("hhhhhhhhhhhhh");
//        serviceDto.getEmployeDtos().addAll(collect);
//        ServiceDto serviceDto1 = serviceService.ajouterService(serviceDto);
//        System.out.println("-----------test enregistre services----------");
//        List<ServiceDto> servicesDtos = serviceService.getServices();
//        servicesDtos.forEach(serviceDto2 -> {
//            System.out.println(serviceDto2.getNom());
//            System.out.println("les employees de ce service");
//            serviceDto2.getEmployeDtos().forEach(em->{
//                System.out.println(em.getId() + "-----" + em.getNom() + "-----" + em.getPrenom());
//            });
//       });
//    }
}
