package com.example.brocker_services_back_end.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class DemandeDto {
    private long id;
    private Date date;
    private List<EmployeDto> employes;
    private List<ClientDto> clients;

}
