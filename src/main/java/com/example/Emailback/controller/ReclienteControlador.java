package com.example.Emailback.controller;

import com.example.Emailback.dto.ReclienteDTO;
import com.example.Emailback.service.ReclienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reusuario")
public class ReclienteControlador {
    @Autowired
    private ReclienteServicio reclienteServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearRecliente(@RequestBody ReclienteDTO dto){
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
        var nuevoRecliente = reclienteServicio.crearRecliente(dto);
        if(nuevoRecliente.getId() != null && nuevoRecliente.getId() == -1L){
            return ResponseEntity.badRequest()
                    .body("Datos incompletos para crear cliente");

        }
        if(nuevoRecliente.getId() != null && nuevoRecliente.getId() == -2L){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un cliente con ese correo registrado");

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRecliente);


    }

}
