package com.example.Emailback.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "refugio")
public class Refugio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refugio", nullable = false)
    private Long idRefugio;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "nombreCorto", nullable = false, length = 50)
    private String nombreCorto;

    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @Column(name = "localidad", nullable = false, length = 60)
    private String localidad;

    @Column(name = "telefono", nullable = false, length = 10)
    private Integer telefono;

    @Column(name = "horario_atencion", nullable = false, length = 100)
    private String horarioAtencion;

    @Column(name = "servicios", nullable = false)
    private String servicios;

    @Column(name = "fecha_fundacion", nullable = false)
    private String fechaFundacion;

    //._-

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "edificio_id")
    private DueñoRefugio edificio; // Relación con edificio existente
}