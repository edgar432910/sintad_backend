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
    @NotBlank
    private String nroDocumento ;

    @NotNull
    @NotBlank
    private String razonSocial;

    @NotNull
    @NotBlank
    private String nombreComercial;

    @NotNull
    private TipoContribuyenteDTO tipoContribuyente;

    @NotNull
    @NotBlank
    private String direccion;

    @NotNull
    @NotBlank
    @Size( max = 50)
    private String telefono;

//    @NotNull
//    @NotBlank
//    private Boolean estado;

}
