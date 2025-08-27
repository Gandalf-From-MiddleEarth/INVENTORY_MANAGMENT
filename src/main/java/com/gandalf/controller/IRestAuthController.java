package com.gandalf.controller;

import com.gandalf.dto.DtoUser;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;

public interface IRestAuthController {
    public DtoUser register(AuthRequest request);
    public AuthResponse authenticate(AuthRequest request);
}
