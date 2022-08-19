package com.P_T.API_SPRING.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TipoDocumentoDTO {

    private Integer idTipoDocumento;
    @NotNull
    @Size( max = 20)
    @NotBlank
    private String codigo;
    @NotNull
    @NotBlank
    @Size( max = 100)
    private String nombre;
    @NotNull
    @NotBlank
    private String descripcion;
//    @NotNull
//    @NotBlank
//    private Boolean estado;

}
