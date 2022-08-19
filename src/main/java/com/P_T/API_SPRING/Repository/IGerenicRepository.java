package com.P_T.API_SPRING.Repository;


import com.P_T.API_SPRING.Model.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IGerenicRepository <T, ID> extends JpaRepository<T,ID> {

    List<T> findByEstado(boolean flag);

}
