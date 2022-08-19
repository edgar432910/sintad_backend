package com.P_T.API_SPRING.Service.Implementacion;

import com.P_T.API_SPRING.Repository.IGerenicRepository;
import com.P_T.API_SPRING.Service.ICrud;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class CrudImpl<T,ID> implements ICrud<T,ID> {

    protected abstract IGerenicRepository<T,ID> getRepo();

    @Override
    public T registrar(T p) throws Exception {
        return getRepo().save(p);
    }

    @Override
    public T modificar(T p) throws Exception {
        return getRepo().save(p);
    }

    @Override
    public List<T> listar() throws Exception {
//        return getRepo().findAll();
        return getRepo().findByEstado(true);
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);
//        T object = getRepo().findById(id).orElse(null);

//        return getRepo().save(p);
    }

}
