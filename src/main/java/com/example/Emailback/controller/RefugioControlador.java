package com.example.Emailback.controller;



import com.example.Emailback.dto.RefugioDTO;
import com.example.Emailback.entity.Refugio;
import com.example.Emailback.service.RefugioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refugios")
@AllArgsConstructor
public class RefugioControlador {

    private final RefugioServicio refugioServicio;

    @PostMapping("/crearefugios")
    public ResponseEntity<?> crearRefugio(@RequestBody RefugioDTO dto){

        // Validaciones separadas para mejor mensaje de error
        if(dto.nombre == null || dto.nombre.isBlank()) {
            return ResponseEntity.badRequest().body("Error: el nombre es obligatorio");
        }

        if(dto.horarioAtencion == null || dto.horarioAtencion.isBlank()) {
            return ResponseEntity.badRequest().body("Error: el horario es obligatorio");
        }

        if(dto.nombreCorto == null || dto.nombreCorto.isBlank()){
            return ResponseEntity.badRequest()
                    .body("Error: el nombre corto es obligatorio");

        }
        if(dto.direccion == null || dto.direccion.isBlank()) {
            return ResponseEntity.badRequest().body("Error: el horario es obligatorio");
        }

        if(dto.localidad == null || dto.localidad.isBlank()){
            return ResponseEntity.badRequest()
                    .body("Error: el nombre corto es obligatorio");

        }
        if(dto.telefono == null) {
            return ResponseEntity.badRequest().body("Error: el horario es obligatorio");
        }

        if(dto.servicios == null || dto.servicios.isBlank()){
            return ResponseEntity.badRequest()
                    .body("Error: el nombre corto es obligatorio");

        }
        if(dto.fechaFundacion == null || dto.fechaFundacion.isBlank()) {
            return ResponseEntity.badRequest().body("Error: el horario es obligatorio");
        }

        if(dto.edificioId == null){
            return ResponseEntity.badRequest()
                    .body("Error: la cedula es obligatoria");

        }
        var nuevoRefugio = refugioServicio.crearRefugio(dto);
        if(nuevoRefugio.getIdRefugio() !=null && nuevoRefugio.getIdRefugio() == -1L){
            return ResponseEntity.badRequest()
                    .body("Datos incompletos para crear refugio");

        }
        if(nuevoRefugio.getIdRefugio() !=null && nuevoRefugio.getIdRefugio() == -2L){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un refugio con ese codigo registrado");




        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRefugio);
    }
    @GetMapping("/crearefugios")
    public List<Refugio>  verrefugio(){
        return refugioServicio.verefugio();
    }


}