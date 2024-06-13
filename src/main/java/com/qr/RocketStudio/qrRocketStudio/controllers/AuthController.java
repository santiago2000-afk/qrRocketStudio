package com.qr.RocketStudio.qrRocketStudio.controllers;

import com.qr.RocketStudio.qrRocketStudio.security.JwtTokenUtil;
import com.qr.RocketStudio.qrRocketStudio.model.Usuario;
import com.qr.RocketStudio.qrRocketStudio.service.AuthService;
import com.qr.RocketStudio.qrRocketStudio.DTO.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            Usuario usuario = authService.authenticate(email, password);
            if (usuario != null) {
                // Generar token JWT
                String token = jwtTokenUtil.generateToken(usuario);

                // Devolver el token como parte de la respuesta
                return ResponseEntity.ok().body(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}