package com.gandalf.controller;

import com.gandalf.dto.DtoEmployeeManagement;
import com.gandalf.dto.DtoEmployeeManagementIU;

import java.util.List;

public interface IRestEmployeeController {

    public DtoEmployeeManagement saveEmployee(DtoEmployeeManagementIU saveEmployee);
    public List<DtoEmployeeManagement> getAllEmployees();
    public DtoEmployeeManagement getEmployeeById(Integer id);
    public DtoEmployeeManagement employeeUpdate(Integer id, DtoEmployeeManagementIU updateEmployee);
    public void deleteEmployee(Integer id);
}