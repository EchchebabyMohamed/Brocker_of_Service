package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.EmployeDto;
import com.example.brocker_services_back_end.DTOs.ServiceDto;
import com.example.brocker_services_back_end.Mappers.EmployeMapper;
import com.example.brocker_services_back_end.Mappers.ServiceMapper;
import com.example.brocker_services_back_end.reposetory.ServiceReposetory;
import com.example.brocker_services_back_end.Exception.SrviceNotFountException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class SeviceServiceImpl implements ServiceService {
    ServiceReposetory serviceReposetory;
    ServiceMapper serviceMapper;
    EmployeMapper employeMapper;
    @Override
    public List<ServiceDto> getServices() {
        List<com.example.brocker_services_back_end.Enteties.Service> services = serviceReposetory.findAll();
        return services.stream()
                .map(sr->serviceMapper.serviceToServiceDto(sr))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto getService(long id) {
        com.example.brocker_services_back_end.Enteties.Service service =
                serviceReposetory.findById(id).orElseThrow(
                () -> new SrviceNotFountException("Service non trouver")
        );
        return serviceMapper.serviceToServiceDto(service);
    }

    @Override
    public ServiceDto ajouterService(ServiceDto serviceDto) {

        return serviceMapper.serviceToServiceDto(serviceReposetory
                .save(serviceMapper.serviceDToToService(serviceDto)));
    }

    @Override
    public ServiceDto modifierService(ServiceDto serviceDto) {
        return serviceMapper.serviceToServiceDto(serviceReposetory
                .save(serviceMapper.serviceDToToService(serviceDto)));
    }

    @Override
    public void supprimerService(long id) {
        serviceReposetory.deleteById(id);
    }

    @Override
    public ServiceDto ajouterEmployerAuService(long id_service, EmployeDto employeDto) {
        com.example.brocker_services_back_end.Enteties.Service service = serviceReposetory.findById(id_service).orElseThrow(
                ()->new SrviceNotFountException("Service non trouvé")
        );
        service.getEmployes().add(employeMapper.deEmployeDToToEmploye(employeDto));
        return serviceMapper.serviceToServiceDto(serviceReposetory.save(service));
    }

    @Override
    public List<EmployeDto> getEmployerDunService(long id_service) {
        com.example.brocker_services_back_end.Enteties.Service service = serviceReposetory.findById(id_service).orElseThrow(
                ()->new SrviceNotFountException("Service non trouvé")
        );
        return service.getEmployes().stream()
                .map(emp->employeMapper.deEmployeToEmployeDto(emp))
                .collect(Collectors.toList());
    }
}
