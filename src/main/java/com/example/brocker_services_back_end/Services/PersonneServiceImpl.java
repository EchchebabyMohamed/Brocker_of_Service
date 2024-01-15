package com.example.brocker_services_back_end.Services;

import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.DTOs.RolesDto;
import com.example.brocker_services_back_end.Enteties.Personne;
import com.example.brocker_services_back_end.Enteties.Roles;
import com.example.brocker_services_back_end.Exception.PersonneNotFoundException;
import com.example.brocker_services_back_end.Exception.RoleExisteException;
import com.example.brocker_services_back_end.Exception.RoleNotFoundException;
import com.example.brocker_services_back_end.Exception.RolePersonneNotExisteException;
import com.example.brocker_services_back_end.Mappers.PersonneMapper;
import com.example.brocker_services_back_end.Mappers.RolesMapper;
import com.example.brocker_services_back_end.reposetory.PersonneReposetory;
import com.example.brocker_services_back_end.reposetory.RolesReposetory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PersonneServiceImpl implements PersonneService {
    private RolesReposetory rolesReposetory;
    private PersonneReposetory personneReposetory;
    private RolesMapper rolesMapper;
    private PersonneMapper personneMapper;
    @Override
    public RolesDto addRole(String role) {
        Roles roles = new Roles();
        roles.setRole(role);
        return rolesMapper.deRoles(rolesReposetory.save(roles));
    }

    @Override
    public void AddRoleToUser(long id_user, String role) throws RoleExisteException {
        Personne personne = personneReposetory.findById(id_user).orElseThrow(
                ()-> new PersonneNotFoundException("utulisateur non trouvé")
        );
        Roles roles = rolesReposetory.findById(role).orElseThrow(
                ()->new RoleNotFoundException("Role non trouvé")
        );
        if (personne.getRoles().indexOf(roles) != -1) {
            throw new RoleExisteException("le role que vous attribué déja existe");
        }
        roles.getPersonnes().add(personne);
        personne.getRoles().add(roles);
        personneReposetory.save(personne);
    }

    @Override
    public void RemoveRoleToUser(long id_user, String role) {
        Personne personne = personneReposetory.findById(id_user).orElseThrow(
                ()-> new PersonneNotFoundException("utulisateur non trouvé")
        );
        Roles roles = rolesReposetory.findById(role).orElseThrow(
                ()->new RoleNotFoundException("Role non trouvé")
        );
        if (personne.getRoles().indexOf(roles) == -1) {
            throw new RolePersonneNotExisteException("le role que vous supprimé de cette " +
                    "utulisateur n'éxiste pas");
        }
        personne.getRoles().remove(roles);
        roles.getPersonnes().remove(personne);
    }
    @Override
    public PersonneDto loadUserByUsername(String mail) {
        return personneMapper.dePersonne(personneReposetory.findByEmail(mail));
    }
}
