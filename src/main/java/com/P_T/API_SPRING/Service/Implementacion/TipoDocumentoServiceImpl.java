package com.P_T.API_SPRING.Service.Implementacion;

import com.P_T.API_SPRING.Model.TipoDocumento;
import com.P_T.API_SPRING.Repository.IGerenicRepository;
import com.P_T.API_SPRING.Repository.ITipoDocumentoRepository;
import com.P_T.API_SPRING.Service.ITipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoServiceImpl extends CrudImpl<TipoDocumento,Integer> implements ITipoDocumentoService {
    @Autowired
    private ITipoDocumentoRepository repo;

    @Override
    protected IGerenicRepository<TipoDocumento, Integer> getRepo() {
        return repo;
    }
}