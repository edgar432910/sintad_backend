package com.P_T.API_SPRING.Exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private LocalDateTime fecha;
    private String mensaje;
    private String detalles;


    public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalles) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public ExceptionResponse() {

    }



}
