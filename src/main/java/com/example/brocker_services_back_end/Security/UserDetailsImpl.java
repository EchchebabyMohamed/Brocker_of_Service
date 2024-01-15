package com.example.brocker_services_back_end.Security;

import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.Services.ClientService;
import com.example.brocker_services_back_end.Services.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsImpl implements UserDetailsService{
    PersonneService personneService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonneDto personneDto = personneService.loadUserByUsername(username);
        if (personneDto == null) throw new UsernameNotFoundException("pas de personne avec cette mail: "+username);
        String[] roles = personneDto.getRolesDtos().stream().map(rl -> rl.getRole()).toArray(String[]::new);
        UserDetails userDetails = User
                .withUsername(personneDto.getEmail())
                .password(personneDto.getPassword())
                .roles(roles)
                .build();
        return userDetails;
    }
}
