package com.P_T.API_SPRING.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idTipoDocumento;
    private String codigo;
    private String nombre;
    private String descripcion;
    @Column(name = "estado",  columnDefinition = "boolean default true")
    private boolean estado;



}
