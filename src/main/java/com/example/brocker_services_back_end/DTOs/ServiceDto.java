package com.example.brocker_services_back_end.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ServiceDto {
    private long id;
    private String nom;
    private String img;
    private String description;
    private List<EmployeDto> employeDtos= new ArrayList<>();
}
