package com.example.baithi.service;

import com.example.baithi.model.EmployeesEntity;

import java.util.List;

public interface EmployeesService {
    public void saveEmployees(EmployeesEntity e);
    public void deleteEmployees(Integer id);
    public EmployeesEntity findById(Integer id);
    public List<EmployeesEntity> findAll();

    public List<EmployeesEntity> findAllByName(String name);
}
