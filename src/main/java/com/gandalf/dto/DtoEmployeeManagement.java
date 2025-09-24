package com.gandalf.dto;

import com.gandalf.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployeeManagement {


    private String firstName;

    private String lastName;

    private MaritalStatus maritalStatus;

    private GraduationStatus graduationStatus;

    private Boolean isActive;

    private Department department;

    private Position position;

    private Gender gender;

    private Date birthDate;
}
