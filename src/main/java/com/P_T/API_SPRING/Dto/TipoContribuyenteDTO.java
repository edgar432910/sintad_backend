package com.P_T.API_SPRING.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TipoContribuyenteDTO {

    private Integer idTipoContribuyente;
    @NotNull
    @NotBlank
    @Size( max = 50)
    private String nombre;


//    @NotNull
//    @NotBlank
    private Boolean estado;
}
