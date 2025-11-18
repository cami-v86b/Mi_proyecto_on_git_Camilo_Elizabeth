package com.example.Emailback;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")

public class EmailSenderController {
    @Autowired
    EmailSenderService emailSenderService;
    @PostMapping("/enviar")

    public ResponseEntity<?> enviarEmail(@RequestBody EmailDTO emaildto) {
        try {
            // Validar campos obligatorios
            if (emaildto.getToEmail() == null || emaildto.getToEmail().isBlank()) {
                return ResponseEntity.badRequest().body("Email destinatario es requerido");
            }

            emailSenderService.sendEmail(emaildto);
            return ResponseEntity.ok("Email enviado exitosamente");

        } catch (Exception e) {
            e.printStackTrace(); // Para ver el error en consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error enviando email: " + e.getMessage());
        }
    }
}




