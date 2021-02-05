package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    Usuario findByApodoAndContrasena(String apodo, String contrasena);

    Usuario findByApodo(String apodo);
}
