package com.example.Emailback.repository;


import com.example.Emailback.entity.Recliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReclienteRepository extends CrudRepository<Recliente,Integer> {
    @Query("SELECT R FROM Recliente R WHERE R.email=:correo AND R.clave=:password")
    Optional<Recliente> login(String correo, String password);
}
