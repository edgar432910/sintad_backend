package com.P_T.API_SPRING.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idTipoDocumento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private boolean estado;



}
