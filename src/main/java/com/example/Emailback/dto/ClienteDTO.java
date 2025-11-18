package com.example.Emailback.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@ToString
public class ClienteDTO {
    public Long id;
    public String email;
    public String clave;
    public boolean vigencia;
    public Long paisId;

}
