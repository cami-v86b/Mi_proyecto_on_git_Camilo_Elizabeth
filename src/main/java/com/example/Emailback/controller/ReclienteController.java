package com.example.Emailback.controller;

import com.example.Emailback.entity.Recliente;
import com.example.Emailback.service.ReclienteService;
import com.example.Emailback.utils.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/reusuario")
public class ReclienteController {
    private final ReclienteService service;

    @PostMapping("/login")
    public GenericResponse<Recliente> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        return this.service.login(email, contrasenia);
    }





}
