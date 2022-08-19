package com.P_T.API_SPRING.Repository;

import com.P_T.API_SPRING.Model.Entidad;
import com.P_T.API_SPRING.Model.TipoContribuyente;

import java.util.List;

public interface ITipoContribuyenteRepository extends IGerenicRepository<TipoContribuyente,Integer>{
    List<TipoContribuyente> findByEstado(boolean flag);
}
