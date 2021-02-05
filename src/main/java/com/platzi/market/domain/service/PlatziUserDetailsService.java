package com.platzi.market.domain.service;

import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioCrudRepository.findByApodo(username);
        return new User(usuario.getApodo(), "{noop}" + usuario.getContrasena(), new ArrayList<>());
    }
}