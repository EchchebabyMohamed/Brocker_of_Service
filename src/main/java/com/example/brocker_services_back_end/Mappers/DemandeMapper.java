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
        demande.setEmploye(employeMapper.deEmployeDToToEmploye(demandeDto.getEmployeDto()));
        demande.setClient(clientMapper.clientDToToClient(demandeDto.getClientDto()));
        return demande;
    }
    public DemandeDto demandeToDemandeDto(Demande demande){
        DemandeDto demandeDto=new DemandeDto();
        BeanUtils.copyProperties(demande,demandeDto);
        demandeDto.setEmployeDto(employeMapper.deEmployeToEmployeDto(demande.getEmploye()));
        demandeDto.setClientDto(clientMapper.clientToClientDto(demande.getClient()));
        return demandeDto;
    }
}
