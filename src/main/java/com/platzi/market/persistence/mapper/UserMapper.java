package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.User;
import com.platzi.market.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "apodo", target = "username"),
            @Mapping(source = "contrasena", target = "password")
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
