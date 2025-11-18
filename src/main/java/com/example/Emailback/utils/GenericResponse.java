package com.example.Emailback.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse <T>{
    private String type;
    private int rpta;
    private String message;
    private T body;
}
