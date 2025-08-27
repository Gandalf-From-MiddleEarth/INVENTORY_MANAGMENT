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
public class DtoAssignmentIU {

    private LocalDate assignmentDate;

    private LocalDate returnDate;

    private Long employeeId;

    private Long inventoryId;

    private Long assigner;

    private Long receiver;
}