package com.cadastraCliente.cadastraCliente.controller;

import com.cadastraCliente.cadastraCliente.controller.dto.LoginDTO;
import com.cadastraCliente.cadastraCliente.controller.dto.TokenDTO;
import com.cadastraCliente.cadastraCliente.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/login")
@RequestScope
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<TokenDTO> authenticateUser(@RequestBody LoginDTO user) {
       return ResponseEntity.ok(authService.login(user.getUsername(), user.getPassword()));
    }
}
