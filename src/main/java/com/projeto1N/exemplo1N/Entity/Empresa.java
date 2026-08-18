package com.projeto1N.exemplo1N.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empresa")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", nullable = false, unique = true)
    private Long id_empresa;

    @Column(name = "nome_empresa", nullable = false, unique = true, length = 100)
    private String nome_empresa;

    @Column(name = "cnpj_empresa", nullable = false, unique = true)
    private String cnpj_empresa;

    @Column(name = "ramo_empresa", nullable = false, length = 100)
    private String ramo_empresa;

}