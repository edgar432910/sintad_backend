package com.P_T.API_SPRING.Repository;

import com.P_T.API_SPRING.Model.Usuario;

public interface IUsuarioRepository extends IGerenicRepository<Usuario, Integer>  {

    //from usuario where username = ?
    //@Query("FROM Usuario us where us.username = ?")
    //Derived Query
    Usuario findOneByUsername(String username);
}