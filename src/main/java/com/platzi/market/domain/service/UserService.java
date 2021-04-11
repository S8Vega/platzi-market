package com.platzi.market.domain.service;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;
import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioCrudRepository.findByApodo(username);
        return new org.springframework.security.core.userdetails.User(usuario.getApodo(), "{noop}" + usuario.getContrasena(), new ArrayList<>());
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    public User save(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userRepository.save(user);
    }
}
