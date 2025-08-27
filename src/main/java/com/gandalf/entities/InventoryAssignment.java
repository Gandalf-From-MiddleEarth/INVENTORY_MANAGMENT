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
public class InventoryAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @ManyToOne
    @JoinColumn
    private Employee employee;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Inventory inventory;
    @ManyToOne
    @JoinColumn
    private Employee assigner;
    @ManyToOne
    private Employee receiver;
}
