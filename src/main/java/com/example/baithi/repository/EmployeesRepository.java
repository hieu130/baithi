package com.example.baithi.repository;

import com.example.baithi.model.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepository  extends JpaRepository<EmployeesEntity, Integer> {
    List<EmployeesEntity> findAllByNameContainsIgnoreCase(String name);

}
