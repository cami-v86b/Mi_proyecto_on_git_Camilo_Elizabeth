package com.example.Emailback.controller;


import com.example.Emailback.entity.DocumentoAlmacenado;
import com.example.Emailback.service.DocumentoAlmacenadoService;
import com.example.Emailback.utils.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {
    private DocumentoAlmacenadoService service;

    public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id, HttpServletRequest request) {
        return service.downloadById(id,request);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request) {
        return service.downloadByFileName(fileName, request);
    }

    @PostMapping
    public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
        return service.save(obj);
    }

    public GenericResponse delete (Long aLong, DocumentoAlmacenado obj) {
        return null;
    }
    @PutMapping("/editImage/{id}")
    public GenericResponse update(@PathVariable Long id, @ModelAttribute DocumentoAlmacenado obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/deleteImage/{id}")
    public GenericResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
