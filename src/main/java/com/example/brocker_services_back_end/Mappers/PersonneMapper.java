package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.ClientDto;
import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.Enteties.Personne;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonneMapper {
    public Personne dePersonneDto(PersonneDto personneDto){
        Personne personne = new Personne();
        BeanUtils.copyProperties(personneDto,personne);
        return personne;
    }

    public PersonneDto dePersonne(Personne personne){
        PersonneDto personneDto = new ClientDto();
        BeanUtils.copyProperties(personne,personneDto);
        return personneDto;
    }

}
