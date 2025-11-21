package com.example.Emailback.service;

import com.example.Emailback.entity.Recliente;
import com.example.Emailback.repository.ReclienteRepository;
import com.example.Emailback.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.Emailback.utils.Global.*;

@AllArgsConstructor

@Service
@Transactional
public class ReclienteService {
    private final ReclienteRepository repository;
    //Metodo para iniciar sesion
    public GenericResponse<Recliente> login(String email, String contrasenia){
        Optional<Recliente> optU = this.repository.login(email, contrasenia);
        if(optU.isPresent()){
            return new GenericResponse<Recliente>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Recliente>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Recliente());
        }
    }
}
