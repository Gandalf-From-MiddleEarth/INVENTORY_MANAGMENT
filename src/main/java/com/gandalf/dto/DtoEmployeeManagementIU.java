package com.gandalf.dto;

import com.gandalf.enums.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeManagementIU {


    @NotEmpty(message = "İsim alanı boş geçilemez")
    @Size(min = 3, max = 50, message = "İsim en az 3 en fazla 50 karekter içerebilir")
    private String firstName;
    @NotEmpty(message = "Soyad alanı boş geçilemez")
    @Size(min = 3, max = 50, message = "Soyad en az 3 en fazla 20 karekter içerebilir")
    private String lastName;
    @NotEmpty(message = "TCKN boş olamaz")
    @Pattern(regexp = "^[0-9]{11}$", message = "TCKN 11 haneli sayısal bir değer olmalıdır")
    private String tckn;
    private LocalDate birthDate;

    private String gender;
    private MaritalStatus maritalStatus;
    private GraduationStatus graduationStatus;
    private Boolean isActive;
    private String profilePhoto;
    private Department department;
    private Position position;
    private Role role;
}