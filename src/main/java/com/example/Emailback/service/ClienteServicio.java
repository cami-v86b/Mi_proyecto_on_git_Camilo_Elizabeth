package com.example.Emailback.service;


import com.example.Emailback.dto.ClienteDTO;
import com.example.Emailback.entity.Cliente;
import com.example.Emailback.entity.DocumentoAlmacenado;
import com.example.Emailback.repository.ClienteRepositorio;
import com.example.Emailback.repository.DocumentoAlmacenadoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteServicio {

     ClienteRepositorio clienteRepositorio;
     DocumentoAlmacenadoRepository documentoAlmacenadoRepository;

    @Transactional
    public Cliente crearCliente(ClienteDTO dto){
        if(clienteRepositorio.existsByEmail(dto.email)){
            Cliente dummy = new Cliente();
            dummy.setId(-2L);
            return dummy;
        }
        if(dto.email == null || dto.clave == null){
            Cliente dummy = new Cliente();
            dummy.setId(-1L);
            return dummy;
        }

        Cliente cliente = getCliente(dto);

        clienteRepositorio.save(cliente);
        return cliente;
    }

    private Cliente getCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setId(dto.id);
        cliente.setEmail(dto.email);
        cliente.setClave(dto.clave);
        cliente.setVigencia(dto.vigencia);
        if(dto.paisId != null){
            DocumentoAlmacenado pais = this.documentoAlmacenadoRepository.findById(dto.paisId)
                    .orElseThrow(()->new RuntimeException("Documento almacenado no encontrado"));
            cliente.setPais(pais);}

        return cliente;
    }

    //public List<>


}
