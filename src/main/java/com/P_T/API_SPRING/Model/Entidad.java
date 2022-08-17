package com.P_T.API_SPRING.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente",referencedColumnName = "idTipoContribuyente")
    private TipoContribuyente tipoContribuyente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento",referencedColumnName = "idTipoDocumento")
    private TipoDocumento tipoDocumento;

    private String nroDocumento ;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;

    private Boolean estado;

}
