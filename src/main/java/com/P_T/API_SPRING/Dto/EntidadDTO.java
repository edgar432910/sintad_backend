package com.P_T.API_SPRING.Dto;

import jdk.jfr.BooleanFlag;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
@Data
public class EntidadDTO {
    private Integer idEntidad;

    @NotNull(message = "{entidad_TD.null}")
    private TipoDocumentoDTO tipoDocumento;

    @NotNull(message = "{entidad_nro.null}")
    @Size( max = 25, message = "{entidad_nro.size}")
    private String nroDocumento ;

    @NotNull(message = "{entidad_razon.null}")
    @Size( max = 100  ,message = "{entidad.size}")
    private String razonSocial;


    @Size( max = 100, message = "{entidad_nombre.size}")
    private String nombreComercial;


    private TipoContribuyenteDTO tipoContribuyente;

    @NotNull(message = "{entidad_direc.null}")
    @Size( max = 250)
    private String direccion;

    @Size( max = 100 , message = "{entidad.size}" )
    private String telefono;

    @NotNull(message = "{estados.null}")

    private Boolean estado;

}
