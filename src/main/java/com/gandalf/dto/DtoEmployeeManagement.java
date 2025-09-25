package com.gandalf.dto;

import com.gandalf.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployeeManagement {


    private Integer id;

    private String firstName;

    private String lastName;

    private MaritalStatus maritalStatus;

    private GraduationStatus graduationStatus;

    private String tckn;

    private Boolean isActive;

    private Department department;

    private Position position;

    private Gender gender;

    private LocalDate birthDate;
}
