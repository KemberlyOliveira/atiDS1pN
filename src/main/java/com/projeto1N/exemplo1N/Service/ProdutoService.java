package com.projeto1N.exemplo1N.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Produto;
import com.projeto1N.exemplo1N.Repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository oProdutoRepository;

    public ProdutoService(ProdutoRepository oProdutoRepository) {
        this.oProdutoRepository = oProdutoRepository;
    }

    public List<Produto> listarTodosProdutos() {
        return oProdutoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto oProduto) {
        return oProdutoRepository.save(oProduto);
    }

    public Optional<Produto> buscarProdutoId(Long id) {
        return oProdutoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        Produto produtoExcluir = buscarProdutoId(id).orElseThrow(
                () -> new IllegalArgumentException("Produto não cadastrado!"));

        oProdutoRepository.delete(produtoExcluir);
    }

    @Transactional
    public void alterarProduto(Long id, Produto dadosAlterar) {
        Produto prodE = buscarProdutoId(id).orElseThrow(
                () -> new IllegalArgumentException("Produto não cadastrado!"));

        prodE.setNome(dadosAlterar.getNome());
        prodE.setPreco(dadosAlterar.getPreco());
        prodE.setEmpresaID(dadosAlterar.getEmpresaID());

    }

}
