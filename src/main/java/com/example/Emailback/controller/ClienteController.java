package com.example.Emailback.controller;


import com.example.Emailback.entity.Cliente;
import com.example.Emailback.service.ClienteService;
import com.example.Emailback.utils.GenericResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/usuario")
public class ClienteController {
    private final ClienteService service;
    @PostMapping("/login")
    public GenericResponse<Cliente> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        return this.service.login(email, contrasenia);
    }

}
