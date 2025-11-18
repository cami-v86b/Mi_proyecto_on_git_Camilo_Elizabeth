package com.example.Emailback.service;


import com.example.Emailback.entity.Cliente;
import com.example.Emailback.repository.ClienteRepository;
import com.example.Emailback.utils.GenericResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


import static com.example.Emailback.utils.Global.*;

@AllArgsConstructor

@Service
@Transactional
public class ClienteService{
    private final ClienteRepository repository;
    //Metodo para iniciar sesion
    public GenericResponse<Cliente> login(String email, String contrasenia){
        Optional<Cliente> optU = this.repository.login(email, contrasenia);
        if(optU.isPresent()){
            return new GenericResponse<Cliente>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Cliente>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Cliente());
        }
    }

}

