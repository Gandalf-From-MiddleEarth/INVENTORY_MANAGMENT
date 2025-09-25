package com.gandalf.entities;

import com.gandalf.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 11, unique = true)
    private String tckn;

    @Column(nullable = false)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "graduation_status")
    @Enumerated(EnumType.STRING)
    private GraduationStatus graduationStatus;

    @Column(nullable = false)
    private Boolean isActive;
    private String profilePhoto; // File path or Base64

    @Enumerated(EnumType.STRING)
    @Column(name = "department",  nullable = false)
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<InventoryAssignment> assignments;

    @OneToMany(mappedBy = "employee")
    private List<EmploymentHistory> employmentHistory;

}
