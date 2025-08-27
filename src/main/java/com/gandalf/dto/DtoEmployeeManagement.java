package com.gandalf.dto;

import com.gandalf.enums.Department;
import com.gandalf.enums.GraduationStatus;
import com.gandalf.enums.MaritalStatus;
import com.gandalf.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
