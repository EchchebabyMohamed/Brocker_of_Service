package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.DTOs.RolesDto;
import com.example.brocker_services_back_end.Enteties.Roles;
import com.example.brocker_services_back_end.Exception.RoleExisteException;

public interface PersonneService {
    public RolesDto addRole(String role);
    public void AddRoleToUser(long id_user,String role) throws RoleExisteException;
    public void RemoveRoleToUser(long id_user, String role);
    public PersonneDto loadUserByUsername(String mail);
}
