package com.example.brocker_services_back_end.Mappers;

import com.example.brocker_services_back_end.DTOs.RolesDto;
import com.example.brocker_services_back_end.Enteties.Roles;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RolesMapper {
    public Roles deRolesDto(RolesDto rolesDto){
        Roles roles = new Roles();
        BeanUtils.copyProperties(rolesDto,roles);
        return roles;
    }

    public RolesDto deRoles(Roles roles){
        RolesDto rolesDto = new RolesDto();
        BeanUtils.copyProperties(roles,rolesDto);
        return rolesDto;
    }
}
