package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.ServiceDto;
import com.example.brocker_services_back_end.Enteties.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ServiceMapper {
    EmployeMapper employeMapper;
    public Service serviceDToToService(ServiceDto serviceDto){
        Service service=new Service();
        BeanUtils.copyProperties(serviceDto,service);
        service.setEmployes(serviceDto.getEmployeDtos().stream()
                .map(emp->employeMapper.deEmployeDToToEmploye(emp))
                .collect(Collectors.toList()));
        return service;
    }
    public ServiceDto serviceToServiceDto(Service service){
        ServiceDto serviceDto=new ServiceDto();
        BeanUtils.copyProperties(service,serviceDto);
        serviceDto.setEmployeDtos(service.getEmployes().stream()
                .map(emp->employeMapper.deEmployeToEmployeDto(emp))
                .collect(Collectors.toList()));
        return serviceDto;
    }
}

