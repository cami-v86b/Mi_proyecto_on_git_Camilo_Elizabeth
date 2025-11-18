package com.example.Emailback;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@ToString
public class EmailDTO {
    public String toEmail;
    public String encabezado;
    public String cuerpo;
}
