package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.Enteties.Employe;
import com.example.brocker_services_back_end.Exception.EmployeNotFountException;
import com.example.brocker_services_back_end.Mappers.EmployeMapper;
import com.example.brocker_services_back_end.reposetory.EmployeReposetory;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class EmployeServiceImpl implements EmployeService {
    EmployeReposetory employeReposetory;
    EmployeMapper employeMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public EmployeDto ajouterEmploye(EmployeDto employeDto) {
        employeDto.setPassword(employeDto.getPassword());
        return employeMapper.deEmployeToEmployeDto(employeReposetory.save(employeMapper
                .deEmployeDToToEmploye(employeDto)));
    }

    @Override
    public EmployeDto modifierEmploye(EmployeDto employeDto) {
        employeDto.setPassword(employeDto.getPassword());
        return employeMapper.deEmployeToEmployeDto(employeReposetory.save(employeMapper
                .deEmployeDToToEmploye(employeDto)));
    }

    @Override
    public void supprimerEmploye(long id) {
        employeReposetory.deleteById(id);
    }

    @Override
    public List<EmployeDto> getEmployes() {
        List<Employe> employes =employeReposetory.findAll();
        return employes.stream().map(emp->employeMapper.deEmployeToEmployeDto(emp))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeDto getEmploye(long id) throws EmployeNotFountException{
        Employe employe = employeReposetory.findById(id).orElseThrow(
                ()->new EmployeNotFountException("Employee n'est pas trouvé")
        );
        return employeMapper.deEmployeToEmployeDto(employe);
    }
}
