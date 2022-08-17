package com.P_T.API_SPRING.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGerenicRepository <T, ID> extends JpaRepository<T,ID> {
}
