package com.example.brocker_services_back_end.reposetory;

import com.example.brocker_services_back_end.Enteties.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeReposetory extends JpaRepository<Employe,Long> {

}
