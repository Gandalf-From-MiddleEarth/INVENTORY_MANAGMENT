package com.gandalf.dto;

import com.gandalf.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoAssignment {

    private Integer id;

    private LocalDate assignmentDate;

    private LocalDate returnDate;

    private DtoEmployeeManagement employeeId;

    private DtoInventoryManagement inventoryId;

    private Employee assigner;

    private Employee receiver;

}