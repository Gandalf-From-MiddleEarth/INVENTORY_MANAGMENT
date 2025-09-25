package com.gandalf.service.impl;

import com.gandalf.dto.DtoEmployeeManagement;
import com.gandalf.dto.DtoEmployeeManagementIU;
import com.gandalf.entities.Employee;
import com.gandalf.enums.Gender;
import com.gandalf.repository.EmployeeRepository;
import com.gandalf.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeManagementRepository;

    @Override
    public DtoEmployeeManagement saveEmployee(DtoEmployeeManagementIU saveEmployee) {
        DtoEmployeeManagement response = new DtoEmployeeManagement();
        Employee employee = new Employee();
        BeanUtils.copyProperties(saveEmployee, employee);
        Employee dbEmployee = employeeManagementRepository.save(employee);
        BeanUtils.copyProperties(dbEmployee, response);
        return response;
    }

    @Override
    public List<DtoEmployeeManagement> getAllEmployees() {
        List<DtoEmployeeManagement> response = new ArrayList<>();
        List<Employee> employeeList = employeeManagementRepository.findAll();
        for (Employee employee : employeeList) {
            DtoEmployeeManagement responseEmployee = new DtoEmployeeManagement();
            BeanUtils.copyProperties(employee, responseEmployee);
            response.add(responseEmployee);
        }
        return  response;
    }

    @Override
    public DtoEmployeeManagement getEmployeeById(Integer employeeId) {
        DtoEmployeeManagement response=null;
        Optional<Employee> opt= employeeManagementRepository.findById(employeeId);
        if (opt.isPresent()) {
            response = new DtoEmployeeManagement();
            BeanUtils.copyProperties(opt.get(), response);
        }
        return response;
    }

    @Override
    public DtoEmployeeManagement employeeUpdate( Integer id,DtoEmployeeManagementIU updateEmployee) {
        Employee employee = new Employee();
        Optional<Employee> optional =  employeeManagementRepository.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
            BeanUtils.copyProperties(updateEmployee, employee);
            Employee dbEmployee = new Employee();
            BeanUtils.copyProperties(employee, dbEmployee);
            employeeManagementRepository.save(dbEmployee);
            DtoEmployeeManagement responseEmployee = new DtoEmployeeManagement();
            BeanUtils.copyProperties(employee, responseEmployee);
            return responseEmployee;
        }
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeManagementRepository.deleteById(id);
    }
}
