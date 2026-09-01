package com.projeto1N.exemplo1N.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository oUsuarioRepository;
    private PasswordEncoder oPasswordEncoder;

    public UsuarioService(UsuarioRepository oUsuarioRepository, PasswordEncoder oPasswordEncoder){
        this.oUsuarioRepository = oUsuarioRepository;
        this.oPasswordEncoder = oPasswordEncoder;
    }

}
