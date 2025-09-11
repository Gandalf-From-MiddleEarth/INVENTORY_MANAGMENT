package com.gandalf.controller.impl;

import com.gandalf.controller.IRestEmployeeController;
import com.gandalf.dto.DtoEmployeeManagement;
import com.gandalf.dto.DtoEmployeeManagementIU;
import com.gandalf.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class RestEmployeeController implements IRestEmployeeController {

    @Autowired
    EmployeeServiceImpl userManagementServiceImpl;

    @PostMapping(path = "/save")
    @Override
    public DtoEmployeeManagement saveEmployee(@RequestBody @Valid DtoEmployeeManagementIU saveEmployee) {
        return userManagementServiceImpl.saveEmployee(saveEmployee);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoEmployeeManagement> getAllEmployees() {
        return userManagementServiceImpl.getAllEmployees();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoEmployeeManagement getEmployeeById(@PathVariable(name = "id") Long id) {
        return userManagementServiceImpl.getEmployeeById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoEmployeeManagement employeeUpdate(@PathVariable(name = "id") Long id, @RequestBody DtoEmployeeManagementIU updateEmployee) {
        return userManagementServiceImpl.employeeUpdate(id, updateEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
    }
}