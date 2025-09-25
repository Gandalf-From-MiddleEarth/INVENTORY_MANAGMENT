package com.gandalf.service.impl;

import com.gandalf.dto.DtoUser;
import com.gandalf.entities.Employee;
import com.gandalf.entities.User;
import com.gandalf.jwt.AuthRequest;
import com.gandalf.jwt.AuthResponse;
import com.gandalf.jwt.JwtService;
import com.gandalf.repository.EmployeeRepository;
import com.gandalf.repository.UserRepository;
import com.gandalf.service.IAuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(auth);

            Optional<User> user = userRepository.findByUsername(request.getUsername());
            if (user.isEmpty()) {
                throw new RuntimeException("User not found");
            }
            String token = jwtService.generateToken(user.get());
            return new AuthResponse(token);

        } catch (Exception e) {
            System.out.println("Authentication Failed: " + e.getMessage());
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Transactional
    @Override
    public DtoUser register(AuthRequest request) {

        Integer userId = request.getEmployeeId();
        DtoUser dtoUser = new DtoUser();
        User user = new User();
        user.setUsername(request.getUsername());

        Optional<Employee> dbEmployee = employeeRepository.findById(Long.valueOf(userId));
        if (dbEmployee.isPresent()) {
            user.setEmployee(dbEmployee.get());
            user.setRole(dbEmployee.get().getRole());
        } else {
            throw new IllegalArgumentException("Employee not found!");
        }
        String password = request.getPassword();
        String passwordPattern = "^[a-zA-Z0-9]{6,15}$";

        if (!password.matches(passwordPattern)) {
            throw new IllegalArgumentException("Password must be 6-15 characters long and can only contain letters/numbers.");
        }

        user.setPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }
}