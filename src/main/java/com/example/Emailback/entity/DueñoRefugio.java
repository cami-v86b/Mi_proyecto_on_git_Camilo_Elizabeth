package com.example.Emailback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "dueno_refugio")
public class DueñoRefugio {

    @Id
    @Column(name = "cedula", nullable = false, unique = true)
    private Long cedula;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name ="edad", nullable = false)
    private Integer edad;

    @Column(name ="genero",length = 20)
    private String genero;

    @Column(name ="ocupacion",length = 50)
    private String ocupacion;

    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;

    @Column(name = "correo",nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "celular", length = 10)
    private Integer celular;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @Column(name = "localidad", length = 30)
    private String localidad;

    @Column(name = "barrio", length = 50)
    private String barrio;
}