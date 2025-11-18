package com.example.Emailback.controller;


import com.example.Emailback.dto.DueñoRefugioDTO;
import com.example.Emailback.service.DueñoRefugioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/duenos")
@AllArgsConstructor
public class DueñoRefugioControlador {

    private final DueñoRefugioServicio duenoRefugioServicio;

    @PostMapping("/crearDuenos")
    public ResponseEntity<?> crearDueno(@RequestBody DueñoRefugioDTO dto) {

        if (dto.cedula == null ||
                dto.nombreCompleto == null || dto.nombreCompleto.isBlank() ||
                dto.correo == null || dto.correo.isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Error: faltan datos obligatorios (cedula, nombre o correo).");
        }

        var nuevoDueno = duenoRefugioServicio.crearDueñoRefugio(dto);

        if (nuevoDueno.getCedula() != null && nuevoDueno.getCedula() == -1L) {
            return ResponseEntity.badRequest()
                    .body("Datos incompletos para crear el dueño del refugio.");
        }

        if (nuevoDueno.getCedula() != null && nuevoDueno.getCedula() == -2L) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un dueño con esa cédula registrada.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDueno);
    }
}
