package com.gandalf.controller.impl;

import com.gandalf.controller.IRestAuthController;
import com.gandalf.dto.DtoUser;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;
import com.gandalf.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;

    @Override
    @PostMapping("register")
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return authService.register(request);
    }


    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request) ;
    }
}
