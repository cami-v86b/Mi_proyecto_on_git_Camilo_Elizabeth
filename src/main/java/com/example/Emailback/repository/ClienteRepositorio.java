package com.example.Emailback.repository;

import com.example.Emailback.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
    boolean existsByEmail(String email);
}
