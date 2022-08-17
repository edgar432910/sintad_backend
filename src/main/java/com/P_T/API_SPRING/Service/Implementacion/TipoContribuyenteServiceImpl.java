package com.P_T.API_SPRING.Service.Implementacion;

import com.P_T.API_SPRING.Model.TipoContribuyente;
import com.P_T.API_SPRING.Repository.IGerenicRepository;
import com.P_T.API_SPRING.Repository.ITipoContribuyenteRepository;
import com.P_T.API_SPRING.Service.ITipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoContribuyenteServiceImpl extends CrudImpl<TipoContribuyente,Integer> implements ITipoContribuyenteService {
    @Autowired
    private ITipoContribuyenteRepository repo;

    @Override
    protected IGerenicRepository<TipoContribuyente, Integer> getRepo() {
        return repo;
    }
}
