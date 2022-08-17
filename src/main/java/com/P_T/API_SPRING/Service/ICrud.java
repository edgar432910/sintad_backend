package com.P_T.API_SPRING.Service;

import java.util.List;

public interface ICrud<T, ID> {
    T registrar(T p) throws Exception;
    T modificar(T p) throws Exception;
    List<T> listar() throws Exception;
    T listarPorId(ID id) throws Exception;
    void eliminar(ID id) throws Exception;

}
