package com.gandalf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoAssignmentCreateIU {

    private LocalDate assignmentDate;

    private Integer employeeId;

    private Integer inventoryId;

    private Integer assigner;

}