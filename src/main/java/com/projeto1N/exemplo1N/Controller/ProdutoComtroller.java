package com.projeto1N.exemplo1N.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto1N.exemplo1N.Entity.Produto;
import com.projeto1N.exemplo1N.Service.EmpresaService;
import com.projeto1N.exemplo1N.Service.ProdutoService;

@Controller
@RequestMapping("produtoCTR")
public class ProdutoComtroller {

    private final ProdutoService oProdutoService;
    private final EmpresaService oEmpresaService;

    public ProdutoComtroller(
            ProdutoService oProdutoService,
            EmpresaService oEmpresaService) {
        this.oProdutoService = oProdutoService;
        this.oEmpresaService = oEmpresaService;
    }

    @GetMapping("/formCadastrar")
    public String showFormCadastrar(Model oModel) {
        oModel.addAttribute("produto", new Produto());
        oModel.addAttribute("empresas", oEmpresaService.listarEmpresas());

        return "cadastrarProduto";

    }

    @GetMapping("/listarAll")
    public String ListarTodosProdutos(Model oModel) {
        oModel.addAttribute("produtos", oProdutoService.listarTodosProdutos());

        return "listarProduto";
    }

    @PostMapping("/salvarProduto")
    public String cadastrarProduto(@ModelAttribute Produto oProduto) {

        if (oProduto.getId_produto() != null) {
            oProdutoService.alterarProduto(
                    oProduto.getId_produto(), oProduto);
        } else {
            oProdutoService.cadastrarProduto(oProduto);
        }
        oProdutoService.cadastrarProduto(oProduto);
        return "redirect:/produtoCTR/listarAll";
    }

    @GetMapping("editarProd/{id}")
    public String atualizarProduto(@PathVariable("id") Long id, Model oModel) {

        Produto produtoExistente = oProdutoService.buscarProdutoId(id).orElseThrow(
                () -> new IllegalArgumentException("Produto  não encontrado com o ID " + id));

        oModel.addAttribute("produto", produtoExistente);
        oModel.addAttribute("empresas", oEmpresaService.listarEmpresas());
        return "cadastrarProduto";
    }

    @GetMapping("/deletarProd/{id}")
    public String deletarProduto(@PathVariable Long id) {

        oProdutoService.deletarProduto(id);
        return "redirect:/produtoCTR/listarAll";
    }

}
