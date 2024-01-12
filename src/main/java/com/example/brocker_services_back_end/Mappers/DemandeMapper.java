package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.DemandeDto;
import com.example.brocker_services_back_end.Enteties.Demande;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DemandeMapper {
    EmployeMapper employeMapper;
    ClientMapper clientMapper;
    public Demande demandeDtoToDemande(DemandeDto demandeDto){
        Demande demande=new Demande();
        BeanUtils.copyProperties(demandeDto,demande);
        demande.setEmployes(demandeDto.getEmployeDtos().stream()
                .map(emp->employeMapper.deEmployeDToToEmploye(emp))
                .collect(Collectors.toList()));
        demande.setClients(demandeDto.getClientDtos().stream()
                .map(cl->clientMapper.clientDToToClient(cl))
                .collect(Collectors.toList()));
        return demande;
    }
    public DemandeDto demandeToDemandeDto(Demande demande){
        DemandeDto demandeDto=new DemandeDto();
        BeanUtils.copyProperties(demande,demandeDto);
        demandeDto.setEmployeDtos(demande.getEmployes().stream()
                .map(emp->employeMapper.deEmployeToEmployeDto(emp))
                .collect(Collectors.toList()));
        demandeDto.setClientDtos(demande.getClients().stream()
                .map(cl->clientMapper.clientToClientDto(cl))
                .collect(Collectors.toList()));
        return demandeDto;
    }
}
