package com.projeto1N.exemplo1N.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nome;

    @Column(name = "preco_produto", nullable = false, length = 100)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresaID;

}
