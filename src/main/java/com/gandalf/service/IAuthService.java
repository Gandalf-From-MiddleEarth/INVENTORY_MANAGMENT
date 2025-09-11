package com.gandalf.service;

import com.gandalf.dto.DtoEmployeeManagement;
import com.gandalf.dto.DtoEmployeeManagementIU;
import com.gandalf.dto.DtoUser;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;

public interface IAuthService {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
