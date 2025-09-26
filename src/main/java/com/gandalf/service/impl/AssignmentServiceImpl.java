package com.gandalf.service.impl;

import com.gandalf.dto.DtoAssignment;
import com.gandalf.dto.DtoAssignmentCreateIU;
import com.gandalf.dto.DtoAssignmentReceiveIU;
import com.gandalf.entities.Employee;
import com.gandalf.entities.Inventory;
import com.gandalf.entities.InventoryAssignment;
import com.gandalf.enums.InventoryStatus;
import com.gandalf.repository.AssignmentRepository;
import com.gandalf.repository.EmployeeRepository;
import com.gandalf.repository.InventoryRepository;
import com.gandalf.service.IAssignmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public DtoAssignment createAssignment(DtoAssignmentCreateIU assignment) {

        if (assignment != null) {
            Employee assigner = employeeRepository.findById(assignment.getAssigner())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            Employee employee = employeeRepository.findById(assignment.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            Inventory inventory = (Inventory) inventoryRepository.findById(assignment.getInventoryId())
                    .orElseThrow();
            List<Inventory> notAssigned = inventoryRepository.notAssigned();

            boolean contains = notAssigned.contains(inventory);

            if (contains && employee.getIsActive() ) {
                InventoryAssignment inventoryAssignment = new InventoryAssignment();
                inventoryAssignment.setAssignmentDate(assignment.getAssignmentDate());
                inventoryAssignment.setInventory(inventory);
                inventoryAssignment.setAssigner(assigner);
                inventoryAssignment.setEmployee(employee);
                assignment.setAssignmentDate(LocalDate.now());
                DtoAssignment dtoAssignment = new DtoAssignment();
                BeanUtils.copyProperties(assignment,dtoAssignment);
                inventory.setStatus(InventoryStatus.ASSIGNED);
                inventoryRepository.save(inventory);
                assignmentRepository.save(inventoryAssignment);
                return dtoAssignment;
            }
            else  {
                throw new RuntimeException("You have entered an invalid or incomplete entry.");
            }

        }
        else {
            throw new RuntimeException("Assignment cannot be null.");
        }
    }

    @Override
    public DtoAssignment getAllAssignments() {
        return (DtoAssignment) assignmentRepository.findAll();
    }

    @Override
    public DtoAssignment receiveAssignment(DtoAssignmentReceiveIU receiveAssignment, Integer id) {
        InventoryAssignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        Employee receiver = employeeRepository.findById(receiveAssignment.getReceiver())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        assignment.setReceiver(receiver);

        assignment.setReturnDate(receiveAssignment.getReturnDate() != null
                ? receiveAssignment.getReturnDate() : LocalDate.now());

        Inventory inventory = assignment.getInventory(); // Assuming Assignment has inventory reference
        inventory.setStatus(InventoryStatus.IN_OFFICE);
        inventoryRepository.save(inventory);

        assignmentRepository.save(assignment);

        DtoAssignment dtoAssignment = new DtoAssignment();
        BeanUtils.copyProperties(assignment, dtoAssignment);

        return dtoAssignment;
    }


}

