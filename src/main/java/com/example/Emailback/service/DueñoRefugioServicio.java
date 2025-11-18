package com.example.Emailback.service;


import com.example.Emailback.dto.DueñoRefugioDTO;
import com.example.Emailback.entity.DueñoRefugio;
import com.example.Emailback.repository.DueñoRefugioRepositorio;
import com.example.Emailback.repository.RefugioRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DueñoRefugioServicio {

    DueñoRefugioRepositorio dueñoRefugioRepositorio;
    RefugioRepositorio refugioRepositorio;

    @Transactional
    public DueñoRefugio crearDueñoRefugio(DueñoRefugioDTO dto) {

        // Validar campos obligatorios
        if (dto.nombreCompleto == null || dto.correo == null) {
            DueñoRefugio dummy = new DueñoRefugio();
            dummy.setCedula(-1L); // Código de error interno
            return dummy;
        }

        // Verificar si ya existe un dueño con la misma cédula
        Optional<DueñoRefugio> existente = dueñoRefugioRepositorio.findById(dto.cedula);
        if (existente.isPresent()) {
            DueñoRefugio dummy = new DueñoRefugio();
            dummy.setCedula(-2L);
            return dummy;
        }

        // Crear y poblar entidad
        DueñoRefugio dueno = getDueñoRefugio(dto);

        // Guardar
        dueñoRefugioRepositorio.save(dueno);
        return dueno;
    }

    private static DueñoRefugio getDueñoRefugio(DueñoRefugioDTO dto) {
        DueñoRefugio dueno = new DueñoRefugio();
        dueno.setCedula(dto.cedula);
        dueno.setNombreCompleto(dto.nombreCompleto);
        dueno.setEdad(dto.edad);
        dueno.setGenero(dto.genero);
        dueno.setOcupacion(dto.ocupacion);
        dueno.setEstadoCivil(dto.estadoCivil);
        dueno.setCorreo(dto.correo);
        dueno.setCelular(dto.celular);
        dueno.setDireccion(dto.direccion);
        dueno.setLocalidad(dto.localidad);
        dueno.setBarrio(dto.barrio);
        return dueno;
    }
}