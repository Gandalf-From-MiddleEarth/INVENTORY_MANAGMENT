package com.gandalf.service;

import com.gandalf.dto.DtoUser;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;

public interface IAuthService {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
