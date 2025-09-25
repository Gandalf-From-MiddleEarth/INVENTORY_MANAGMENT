package com.gandalf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String startPosition;
    @Column(nullable = false)
    private String startTitle;
    private LocalDate endDate;
    private String reasonForLeaving;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Employee employee;
}
