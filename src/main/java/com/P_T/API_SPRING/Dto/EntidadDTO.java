package com.P_T.API_SPRING.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class EntidadDTO {
    private Integer idEntidad;

    @NotNull
    private TipoDocumentoDTO tipoDocumento;

    @NotNull
    @Size( max = 25)
    @NotBlank
    private String nroDocumento ;

    @NotNull
    @Size( max = 100)
    @NotBlank
    private String razonSocial;


    @Size( max = 100)
    private String nombreComercial;

    @NotNull
    private TipoContribuyenteDTO tipoContribuyente;

    @NotNull
    @Size( max = 250)
    @NotBlank
    private String direccion;

    @Size( max = 100)
    private String telefono;

    @NotNull
    private Boolean estado;

}
