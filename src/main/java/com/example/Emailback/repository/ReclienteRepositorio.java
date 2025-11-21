package com.example.Emailback.repository;

import com.example.Emailback.entity.Recliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclienteRepositorio extends JpaRepository<Recliente,Long> {
    boolean existsByEmail(String email);
}
