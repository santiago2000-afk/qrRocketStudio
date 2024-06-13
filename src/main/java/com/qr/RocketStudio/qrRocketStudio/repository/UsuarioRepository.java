package com.qr.RocketStudio.qrRocketStudio.repository;

import com.qr.RocketStudio.qrRocketStudio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);
}