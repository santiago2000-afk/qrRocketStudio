package com.qr.RocketStudio.qrRocketStudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qr.RocketStudio.qrRocketStudio.model.Usuario;
import com.qr.RocketStudio.qrRocketStudio.repository.UsuarioRepository;

import java.util.Optional;

import javax.naming.AuthenticationException;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario authenticate(String email, String password) throws AuthenticationException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Verificar la contraseña utilizando PasswordEncoder
            if (passwordEncoder.matches(password, usuario.getPsswrd())) {
                return usuario;
            } else {
                throw new AuthenticationException("Contraseña incorrecta");
            }
        } else {
            throw new AuthenticationException("Usuario no encontrado");
        }
    }
}
