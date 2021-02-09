package com.platzi.market.domain.service;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    public User save(User user) {
        user.setPassword(Integer.toString(user.getPassword().hashCode()));
        return userRepository.save(user);
    }
}
