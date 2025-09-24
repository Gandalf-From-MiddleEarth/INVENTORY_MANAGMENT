package com.gandalf.dto;

import com.gandalf.entities.InventoryAssignment;
import com.gandalf.enums.InventoryStatus;
import com.gandalf.enums.InventoryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoInventoryManagementIU {

    @NotEmpty(message = "Envanter seri no boş geçilemez")
    private String serialNumber;

    @NotEmpty(message = "Envanter markası no boş geçilemez")
    private String brand;

    @NotEmpty(message = "Envanter modeli no boş geçilemez")
    private String model;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate entryDate;

    @NotNull(message = "Envanter Tipi boş geçilemez.")
    @Enumerated(EnumType.STRING)
    private InventoryType type;

    private InventoryStatus status;

    private List<InventoryAssignment> assignments;

}