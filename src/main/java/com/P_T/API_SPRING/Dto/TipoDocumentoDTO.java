package com.P_T.API_SPRING.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TipoDocumentoDTO {

    private Integer idTipoDocumento;
    @NotNull
    @Size( max = 20, message = "{documento_cod.size}")
    private String codigo;
    @NotNull(message = "{nombres.null}")
    @Size( max = 100 , message = "{nombres.size}")
    private String nombre;

    @Size( max = 200, message = "{documento_desc.size}")
    private String descripcion;

    @NotNull(message = "{estados.null}")
    private Boolean estado;

}
