package com.example.Emailback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cliente")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , nullable = false)
    public Long id;
    public String email;
    public String clave;
    public boolean vigencia;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id")
    private DocumentoAlmacenado pais;



}
