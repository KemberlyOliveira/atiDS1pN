package com.projeto1N.exemplo1N.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionario;

    @Column(name = "nome_funcionario", nullable = false, length = 100)
    private String nome_funcionario;

    @Column(name = "cargo_funcionario", nullable = false, length = 100)
    private String cargo_funcionario;
    
    @Column(name = "salario_funcionario", nullable = false, length = 100)
    private Double salario_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresaID;

}
