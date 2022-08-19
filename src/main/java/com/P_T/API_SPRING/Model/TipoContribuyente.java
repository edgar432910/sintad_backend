package com.P_T.API_SPRING.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TipoContribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idTipoContribuyente;
    private String nombre;
    @Column(name = "estado",  columnDefinition = "boolean default true")
    private Boolean estado;
}
