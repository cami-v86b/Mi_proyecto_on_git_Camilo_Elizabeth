package com.example.Emailback.repository;


import com.example.Emailback.entity.DueñoRefugio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DueñoRefugioRepositorio extends JpaRepository<DueñoRefugio, Long> {
    Optional<DueñoRefugio> findByCedula(Long cedula);
}
