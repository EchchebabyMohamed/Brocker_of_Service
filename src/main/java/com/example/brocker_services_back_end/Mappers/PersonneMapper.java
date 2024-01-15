package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.Enteties.Personne;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonneMapper {
    RolesMapper rolesMapper;
    public Personne dePersonneDto(PersonneDto personneDto){
        Personne personne = new Personne();
        BeanUtils.copyProperties(personneDto,personne);
        personne.getRoles().addAll(personneDto.getRolesDtos()
                .stream().map(rl->rolesMapper.deRolesDto(rl))
                .collect(Collectors.toList()));
        return personne;
    }

    public PersonneDto dePersonne(Personne personne){
        PersonneDto personneDto = new ClientDto();
        BeanUtils.copyProperties(personne,personneDto);
        personneDto.getRolesDtos().addAll(personne.getRoles()
                .stream().map(rl->rolesMapper.deRoles(rl))
                .collect(Collectors.toList()));
        return personneDto;
    }

}
