package com.gandalf.dto;

import com.gandalf.enums.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeManagementIU {


    @NotEmpty(message = "İsim alanı boş geçilemez.")
    @Size(min = 3, max = 50, message = "İsim en az 3 en fazla 50 karekter içerebilir.")
    private String firstName;
    @NotEmpty(message = "Soyad alanı boş geçilemez.")
    @Size(min = 3, max = 50, message = "Soyad en az 3 en fazla 20 karekter içerebilir.")
    private String lastName;
    @NotEmpty(message = "TCKN boş olamaz.")
    @Pattern(regexp = "^[0-9]{11}$", message = "TCKN 11 haneli sayısal bir değer olmalıdır.")
    private String tckn;
    @NotNull(message = "Dogum tarihi boş geçilemez.")
    private Date birthDate;
    @NotNull(message = "Cinsiyet alanı boş bırakılamaz.")
    private String gender;
    @NotNull(message = "Çalışanın medeni hali boş geçilemez.")
    private MaritalStatus maritalStatus;
    @NotNull
    private GraduationStatus graduationStatus;
    @NotNull(message = "Çalışan durumu boş geçilemez.")
    private Boolean isActive;

    private String profilePhoto;
    @NotNull(message = "Çalışanın departmanı alanı boş geçilemez.")
    private Department department;
    @NotNull(message = "Çalışanın pozisyonu bpş geçilemez")
    private Position position;
    @NotNull(message = "Çalışanın rolü boş geçilemez.")
    private Role role;
}