package com.gandalf.dto;

import com.gandalf.enums.InventoryStatus;
import com.gandalf.enums.InventoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoInventoryManagement {

    private Integer id;
    private String serialNumber;
    private String brand;
    private String model;
    private LocalDate entryDate;
    private InventoryType type;
    private InventoryStatus status;
}