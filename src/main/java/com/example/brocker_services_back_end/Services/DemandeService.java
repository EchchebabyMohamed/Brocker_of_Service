package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.DemandeDto;

import java.util.List;

public interface DemandeService {
    public List<DemandeDto> getDemandes();
    public DemandeDto getDemande(long id);
    public DemandeDto ajouteDemande(DemandeDto demandeDto);
    public DemandeDto modifierDemande(DemandeDto demandeDto);
    public void supprimerDemande(long id);
    public List<DemandeDto> getDemandesClients(long id_client);
    public List<DemandeDto> getDemandesEmployees(long id_emp);
}
