package com.example.Emailback.controller;


import com.example.Emailback.dto.ClienteDTO;
import com.example.Emailback.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class ClienteControlador {

    @Autowired
    private  ClienteServicio clienteServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO dto){
        if(dto.email == null || dto.email.isBlank()){
            return ResponseEntity.badRequest().body("Error el correo es obligatorio");
        }
        if(dto.clave == null || dto.clave.isBlank()){
            return ResponseEntity.badRequest().body("Error la clave es obligatoria");
        }
        if(dto.paisId == null){
            return ResponseEntity.badRequest()
                    .body("Error: La imagen es obligatoria");
        }
        var nuevoCliente = clienteServicio.crearCliente(dto);
        if(nuevoCliente.getId() != null && nuevoCliente.getId() == -1L){
            return ResponseEntity.badRequest()
                    .body("Datos incompletos para crear cliente");

        }
        if(nuevoCliente.getId() != null && nuevoCliente.getId() == -2L){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un cliente con ese correo registrado");

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);


    }


}
