package com.example.brocker_services_back_end.web;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.Services.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeController {
    private EmployeService employeService;
    @GetMapping("/Employees/{id}")
    public EmployeDto getEmployee(@PathVariable(name = "id") long id){
        return employeService.getEmploye(id);
    }
    @GetMapping("/Employees")
    public List<EmployeDto> getEmployees(){
        return employeService.getEmployes();
    }

    @PutMapping("/Employees/Edit/{id}")
    public EmployeDto EditEmploye(@PathVariable(name = "id") long id,@RequestBody EmployeDto employeDto){
        employeDto.setId(id);
        return employeService.modifierEmploye(employeDto);
    }
    @PostMapping ("/Employees/add")
    public EmployeDto addEmploye(@RequestBody EmployeDto employeDto){
        return employeService.ajouterEmploye(employeDto);
    }

    @DeleteMapping("/Employees/delete/{id}")
    public void deleteEmploye(@PathVariable(name = "id") long id){
        employeService.supprimerEmploye(id);
    }

}
