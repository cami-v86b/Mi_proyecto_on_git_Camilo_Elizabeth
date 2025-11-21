package com.example.Emailback.service;

import com.example.Emailback.dto.ReclienteDTO;
import com.example.Emailback.entity.DocumentoAlmacenado;
import com.example.Emailback.entity.Recliente;
import com.example.Emailback.repository.DocumentoAlmacenadoRepository;
import com.example.Emailback.repository.ReclienteRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReclienteServicio {
    ReclienteRepositorio reclienteRepositorio;
    DocumentoAlmacenadoRepository documentoAlmacenadoRepository;

    @Transactional
    public Recliente crearRecliente(ReclienteDTO dto) {
        if (reclienteRepositorio.existsByEmail(dto.email)) {
            Recliente dummy = new Recliente();
            dummy.setId(-2L);
            return dummy;
        }
        if (dto.email == null || dto.clave == null) {
            Recliente dummy = new Recliente();
            dummy.setId(-1L);
            return dummy;
        }
        Recliente recliente = getRecliente(dto);

        reclienteRepositorio.save(recliente);
        return recliente;

    }

    private Recliente getRecliente(ReclienteDTO dto) {
        Recliente recliente = new Recliente();
        recliente.setId(dto.id);
        recliente.setEmail(dto.email);
        recliente.setClave(dto.clave);
        recliente.setVigencia(dto.vigencia);
        if (dto.paisId != null) {
            DocumentoAlmacenado pais = this.documentoAlmacenadoRepository.findById(dto.paisId)
                    .orElseThrow(() -> new RuntimeException("Documento almacenado no encontrado"));
            recliente.setPais(pais);
        }

        return recliente;
    }
}

