package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.DTOs.ServiceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceService {
    public List<ServiceDto> getServices();
    public ServiceDto getService(long id);
    public ServiceDto ajouterService(ServiceDto serviceDto);
    public ServiceDto modifierService(ServiceDto serviceDto);
    public void supprimerService(long id);
    public ServiceDto ajouterEmployerAuService(long id_service, EmployeDto employeDto);
    public List<EmployeDto> getEmployerDunService(long id_service);
}
