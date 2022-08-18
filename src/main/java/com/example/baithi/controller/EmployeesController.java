package com.example.baithi.controller;

import com.example.baithi.model.EmployeesEntity;
import com.example.baithi.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeesEntity>> findAllEmployees() {
        List<EmployeesEntity> lsEmployees = employeesService.findAll();
        if(lsEmployees.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EmployeesEntity>>(lsEmployees, HttpStatus.OK);
    }



    @RequestMapping(value = "employeesbyname", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeesEntity>> findAllEmployees(@PathParam("name") String name) {
        List<EmployeesEntity> lsEmployees = employeesService.findAllByName(name);
        if(lsEmployees.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EmployeesEntity>>(lsEmployees, HttpStatus.OK);
    }

    @RequestMapping(value = "saveemployees", method = RequestMethod.POST)
    public ResponseEntity<EmployeesEntity> saveNewEmployees(@RequestBody EmployeesEntity e) {
        employeesService.saveEmployees(e);
        return new ResponseEntity<EmployeesEntity>(e, HttpStatus.OK);
    }


    @RequestMapping(value = "updateemployees", method = RequestMethod.PUT)
    public ResponseEntity<EmployeesEntity> updateEmployees(
            @PathParam("id") Integer id,
            @RequestBody EmployeesEntity e) {
        EmployeesEntity oldEmployees = employeesService.findById(id);
        oldEmployees.setName(e.getName());
        oldEmployees.setWage(e.getWage());
        employeesService.saveEmployees(oldEmployees);
        return new ResponseEntity<EmployeesEntity>(oldEmployees, HttpStatus.OK);
    }


    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()  + " "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

}
