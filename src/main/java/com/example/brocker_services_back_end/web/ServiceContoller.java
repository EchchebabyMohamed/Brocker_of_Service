package com.example.brocker_services_back_end.web;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.DTOs.ServiceDto;
import com.example.brocker_services_back_end.Services.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@AllArgsConstructor
public class ServiceContoller {
    ServiceService serviceService;
    @GetMapping("/Sevices")
    public List<ServiceDto> getServices(){
       return serviceService.getServices();
    }

    @GetMapping("/Sevices/{id}")
    public ServiceDto getService(@PathVariable long id){
        return serviceService.getService(id);
    }

    @PostMapping("/Sevices/add")
    public ServiceDto addService(@RequestBody ServiceDto serviceDto){
        return serviceService.ajouterService(serviceDto);
    }

    @PutMapping("/Sevices/Edit/{id}")
    public ServiceDto editService(@PathVariable long id,@RequestBody ServiceDto serviceDto){
        serviceDto.setId(id);
        return serviceService.modifierService(serviceDto);
    }

    @DeleteMapping("/Sevices/delete/{id}")
    public void deleteService(@PathVariable long id){
         serviceService.supprimerService(id);
    }

    @GetMapping("/Sevices/{id}/employees")
    public List<EmployeDto> getServicesEmployees(@PathVariable long id){
        return serviceService.getEmployerDunService(id);
    }

    @PostMapping("/Sevices/{id}/employees/add")
    public ServiceDto addServicesEmployees(@PathVariable long id,@RequestBody EmployeDto employeDto){
        return serviceService.ajouterEmployerAuService(id,employeDto);
    }
}
