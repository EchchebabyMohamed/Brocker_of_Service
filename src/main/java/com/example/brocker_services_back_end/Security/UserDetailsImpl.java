package com.example.brocker_services_back_end.Security;

import com.example.brocker_services_back_end.DTOs.PersonneDto;
import com.example.brocker_services_back_end.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsImpl implements UserDetailsService {
    ClientService clientService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonneDto personneDto = clientService.loadUserByUsername(username);
        if (personneDto == null) throw new UsernameNotFoundException("personne not found");
        UserDetails userDetails = User
                .withUsername(personneDto.getEmail())
                .password(personneDto.getPassword())
                .roles(personneDto.getRole())
                .build();
        return userDetails;
    }
}
