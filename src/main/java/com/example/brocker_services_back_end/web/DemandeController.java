package com.example.brocker_services_back_end.web;

import com.example.brocker_services_back_end.DTOs.DemandeDto;
import com.example.brocker_services_back_end.Services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemandeController {
    @Autowired
    DemandeService demandeService;

    @PostMapping("/Sevices/addDemande")
    public void ajouterDemande(@RequestBody DemandeDto demandeDto){
        System.out.println("l'ajout d'une demmande nouvelle ");
        DemandeDto demandeDto1 = demandeService.ajouteDemande(demandeDto);
        System.out.println("l'enregistrement est bient ajouté est :::"+demandeDto1.getId());
    }
    @GetMapping("/getDemandes")
    public List<DemandeDto> getDemandes(){
        return demandeService.getDemandes();
    }

}
