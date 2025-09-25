package com.gandalf.jwt;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotEmpty(message = "Kullanıcı adı boş geçilemez.")
    private String username;
    @NotEmpty(message = "Şifre boş geçilemez.")
    private String password;

    private Integer employeeId;
}
