package com.gandalf.service.impl;

import com.gandalf.dto.DtoUser;
import com.gandalf.entities.User;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;
import com.gandalf.jwt.JwtService;
import com.gandalf.repository.UserRepository;
import com.gandalf.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider  authenticationProvider;


    @Autowired
    private JwtService jwtService;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(auth);
            Optional<User> user = userRepository.findByUsername(request.getUsername());
            String token = jwtService.generateToken(user.get());

            return new AuthResponse(token);
        } catch (Exception e) {
            System.out.println("Authentication Failed : ");
        }
        return null;
    }

    @Override
    public DtoUser register(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser,dtoUser);
        return dtoUser;
    }
}