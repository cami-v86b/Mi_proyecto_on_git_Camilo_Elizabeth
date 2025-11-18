package com.example.Emailback.repository;


import com.example.Emailback.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    @Query("SELECT U FROM Cliente U WHERE U.email=:correo AND U.clave=:password")
    Optional<Cliente> login(String correo, String password);

}
