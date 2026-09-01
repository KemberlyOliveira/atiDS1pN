package com.projeto1N.exemplo1N.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_usuario", unique = true, nullable = false)
    private Long id_usuario;

    @Column (name = "nome_usuario", nullable = false)
    private String nome;

    @Column (name = "telefone", nullable = false, unique = true)
    private String telefone;

    @Column (name = "username", nullable = false, unique = true)
    private String username;

    @Column (name = "password", nullable = false)
    private String password;

    @Column (name = "role")
    private String role;

    public Usuario() {
    }

    public Usuario(Long id_usuario, String nome, String telefone, String username, String password, String role) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
        this.role = role;
    }   

}
