package com.P_T.API_SPRING.Service;

import com.P_T.API_SPRING.Model.TipoContribuyente;

import java.util.List;

public interface ITipoContribuyenteService extends ICrud<TipoContribuyente,Integer>{

    List<TipoContribuyente>TIPO_CONTRIBUYENTE_LIST () throws Exception;
}
