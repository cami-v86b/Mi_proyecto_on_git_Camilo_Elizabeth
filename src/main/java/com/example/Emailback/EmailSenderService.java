package com.example.Emailback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;



    public void sendEmail(EmailDTO emaildto){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("bonillaedward48@yahoo.com");
        message.setTo(emaildto.toEmail);
        message.setText(emaildto.cuerpo);
        message.setSubject(emaildto.encabezado);

        mailSender.send(message);

        System.out.println("Correo enviado exitosamente......");

    }

}
