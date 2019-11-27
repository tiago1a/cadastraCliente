package com.cadastraCliente.cadastraCliente.service;

import com.cadastraCliente.cadastraCliente.config.JwtTokenProvider;
import com.cadastraCliente.cadastraCliente.controller.dto.TokenDTO;
import com.cadastraCliente.cadastraCliente.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public TokenDTO login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(userRepository.findByUsername(username));
            return new TokenDTO(token);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid username/password supplied");
        }
    }
}
