package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeService {
    public EmployeDto ajouterEmploye(EmployeDto employeDto);
    public EmployeDto modifierEmploye(EmployeDto employeDto);
    public void supprimerEmploye(long id);
    public List<EmployeDto> getEmployes();
    public EmployeDto getEmploye(long id);
}
