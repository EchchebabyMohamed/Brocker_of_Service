package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.Enteties.Employe;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmployeMapper {
    public Employe deEmployeDToToEmploye(EmployeDto employeDto){
        Employe employe = new Employe();
        BeanUtils.copyProperties(employeDto,employe);
        return employe;
    }
    public EmployeDto deEmployeToEmployeDto(Employe employe){
        EmployeDto employeDto = new EmployeDto();
        BeanUtils.copyProperties(employe,employeDto);
        return employeDto;
    }
}
