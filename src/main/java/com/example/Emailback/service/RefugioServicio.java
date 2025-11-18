package com.example.Emailback.service;


import com.example.Emailback.dto.RefugioDTO;
import com.example.Emailback.entity.DueñoRefugio;
import com.example.Emailback.entity.Refugio;
import com.example.Emailback.repository.DueñoRefugioRepositorio;
import com.example.Emailback.repository.RefugioRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RefugioServicio {

    RefugioRepositorio refugioRepositorio;
    DueñoRefugioRepositorio dueñoRefugioRepositorio;

    @Transactional
    public Refugio crearRefugio(RefugioDTO dto){

        //validar campos obligatorios
        if(dto.nombre ==null || dto.telefono == null){
            Refugio dummy = new Refugio();
            dummy.setIdRefugio(-1L);
            return dummy;
        }
        //Crear y probar entidad
        Refugio refugio = getRefugio(dto);

        //Guardar
        refugioRepositorio.save(refugio);
        return refugio;

        //



    }
    private Refugio getRefugio(RefugioDTO dto){
        Refugio refugio = new Refugio();
        refugio.setIdRefugio(dto.idRefugio);
        refugio.setNombre(dto.nombre);
        refugio.setNombreCorto(dto.nombreCorto);
        refugio.setDireccion(dto.direccion);
        refugio.setLocalidad(dto.localidad);
        refugio.setTelefono(dto.telefono);
        refugio.setHorarioAtencion(dto.horarioAtencion);
        refugio.setServicios(dto.servicios);
        refugio.setFechaFundacion(dto.fechaFundacion);
        if(dto.edificioId != null) {
            DueñoRefugio edificio = this.dueñoRefugioRepositorio.findById(dto.edificioId)
                    .orElseThrow(() -> new RuntimeException("Edificio no encontrado"));
            refugio.setEdificio(edificio);}
        return refugio;
    }

    public List<Refugio> verefugio(){
        List<Refugio> refugios = new ArrayList<Refugio>();
        refugios.addAll(refugioRepositorio.findAll());
        return refugios;
    }


}