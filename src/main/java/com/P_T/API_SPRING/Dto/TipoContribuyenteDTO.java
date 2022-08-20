package com.P_T.API_SPRING.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TipoContribuyenteDTO {

    private Integer idTipoContribuyente;
    @NotNull(message = "{nombres.null}")
    @Size( max = 50 , message = "{contribuyente_nombre.size}")
    private String nombre;


    @NotNull(message = "{estados.null}")
    private Boolean estado;
}
