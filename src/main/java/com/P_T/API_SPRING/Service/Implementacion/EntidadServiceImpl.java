package com.P_T.API_SPRING.Service.Implementacion;

import com.P_T.API_SPRING.Model.Entidad;
import com.P_T.API_SPRING.Repository.IEntidadRepository;
import com.P_T.API_SPRING.Repository.IGerenicRepository;
import com.P_T.API_SPRING.Service.IEntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntidadServiceImpl extends CrudImpl<Entidad,Integer> implements IEntidadService {
    @Autowired
    private IEntidadRepository repo;

    @Override
    protected IGerenicRepository<Entidad, Integer> getRepo() {
        return repo;
    }
}
