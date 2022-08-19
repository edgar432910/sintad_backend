package com.P_T.API_SPRING.Model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false, unique = true)
    private String username;

    @Column(name = "clave", nullable = false)
    private String password;
    @Column(name = "estado", nullable = false)
    private boolean estado;
}
