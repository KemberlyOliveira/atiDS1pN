package com.projeto1N.exemplo1N.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto1N.exemplo1N.Entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> ffindByUsername(String username);
}
