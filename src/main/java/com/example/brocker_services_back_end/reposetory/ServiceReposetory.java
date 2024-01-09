package com.example.brocker_services_back_end.reposetory;
import com.example.brocker_services_back_end.Enteties.Employe;
import com.example.brocker_services_back_end.Enteties.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceReposetory extends JpaRepository<Service,Long> {
    public List<Employe> findDistinctById(long id);
}
