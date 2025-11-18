package com.example.Emailback.repository;


import com.example.Emailback.entity.Refugio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugioRepositorio extends JpaRepository<Refugio, Long> {
}
