package com.P_T.API_SPRING.Service.Implementacion;

import com.P_T.API_SPRING.Model.Usuario;
import com.P_T.API_SPRING.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repo.findOneByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

            roles.add(new SimpleGrantedAuthority("administrador"));
//        GrantedAuthority rol = new SimpleGrantedAuthority("administrador");

        UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), usuario.isEstado(), true, true, true, roles);

        return ud;
    }

}