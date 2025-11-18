package com.example.Emailback;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@ToString

public class Email {
    private String toEmail;
    private String encabezado;
    private String cuerpo;

}
