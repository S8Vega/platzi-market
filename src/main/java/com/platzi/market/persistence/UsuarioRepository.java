package com.platzi.market.persistence;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;
import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User getByUsername(String username) {
        return mapper.toUser(usuarioCrudRepository.findByApodo(username));
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return mapper.toUser(usuarioCrudRepository.findByApodoAndContrasena(username, password));
    }

    @Override
    public User save(User user) {
        return mapper.toUser(usuarioCrudRepository.save(mapper.toUsuario(user)));
    }
}
