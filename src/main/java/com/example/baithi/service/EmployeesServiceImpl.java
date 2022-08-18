package com.example.baithi.service;

import com.example.baithi.model.EmployeesEntity;
import com.example.baithi.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
    EmployeesRepository employeesRepository;
    @Override
    public void saveEmployees(EmployeesEntity e) {
        employeesRepository.save(e);
    }

    @Override
    public void deleteEmployees(Integer id) {
        employeesRepository.deleteById(id);
    }

    @Override
    public EmployeesEntity findById(Integer id) {
        return employeesRepository.findById(id).get();
    }

    @Override
    public List<EmployeesEntity> findAll() {
        return employeesRepository.findAll();
    }

    @Override
    public List<EmployeesEntity> findAllByName(String name) {
        return employeesRepository.findAllByNameContainsIgnoreCase(name);
    }
}
