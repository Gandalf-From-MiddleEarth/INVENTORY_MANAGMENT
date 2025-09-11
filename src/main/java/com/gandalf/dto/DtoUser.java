package com.gandalf.dto;

import com.gandalf.entities.Employee;
import com.gandalf.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DtoUser {

    @NotEmpty
    private String username;
    @Size(min = 6, max = 20)
    private String password;

}
