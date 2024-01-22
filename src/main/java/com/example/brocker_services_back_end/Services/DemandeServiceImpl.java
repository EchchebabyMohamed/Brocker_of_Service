package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.DemandeDto;
import com.example.brocker_services_back_end.Enteties.Client;
import com.example.brocker_services_back_end.Enteties.Demande;
import com.example.brocker_services_back_end.Exception.ClientNotFountException;
import com.example.brocker_services_back_end.Exception.DemandeNotFoundException;
import com.example.brocker_services_back_end.Mappers.DemandeMapper;
import com.example.brocker_services_back_end.reposetory.ClientReposetory;
import com.example.brocker_services_back_end.reposetory.DemandeReposetory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DemandeServiceImpl implements DemandeService {
    private DemandeReposetory demandeReposetory;
    private DemandeMapper demandeMapper;
    private ClientReposetory clientReposetory;
    @Override
    public List<DemandeDto> getDemandes() {
        return demandeReposetory.findAll().stream()
                .map(de->demandeMapper.demandeToDemandeDto(de))
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDto getDemande(long id) {
        Demande demande = demandeReposetory.findById(id).orElseThrow(
                () -> new DemandeNotFoundException("demande non trouvé")
        );
        return demandeMapper.demandeToDemandeDto(demande);
    }

    @Override
    public DemandeDto ajouteDemande(DemandeDto demandeDto) {
       return demandeMapper.demandeToDemandeDto(demandeReposetory
               .save(demandeMapper.demandeDtoToDemande(demandeDto)));

    }

    @Override
    public DemandeDto modifierDemande(DemandeDto demandeDto) {
        return demandeMapper.demandeToDemandeDto(demandeReposetory
                .save(demandeMapper.demandeDtoToDemande(demandeDto)));
    }

    @Override
    public void supprimerDemande(long id) {
        demandeReposetory.deleteById(id);
    }

    @Override
    public List<DemandeDto> getDemandesClients(long id_client) {
        Client client = clientReposetory.findById(id_client).orElseThrow(
                ()-> new ClientNotFountException("client non trouvé")
        );
        return client.getDemandes().stream()
                .map(de->demandeMapper.demandeToDemandeDto(de))
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDto> getDemandesEmployees(long id_emp) {
        return null;
    }
}
