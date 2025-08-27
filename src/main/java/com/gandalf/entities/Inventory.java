package com.gandalf.entities;

import com.gandalf.enums.InventoryStatus;
import com.gandalf.enums.InventoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String serialNumber;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Brand brand;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Model model;
    @Column(nullable = false)
    private LocalDate entryDate;
    @Enumerated(EnumType.STRING)
    private InventoryType type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;
    @OneToMany(mappedBy = "inventory")
    private List<InventoryAssignment> assignments;
}
