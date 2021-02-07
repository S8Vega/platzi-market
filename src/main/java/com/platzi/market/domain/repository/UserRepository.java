package com.platzi.market.domain.repository;

import com.platzi.market.domain.User;

public interface UserRepository {
    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    User save(User user);
}
