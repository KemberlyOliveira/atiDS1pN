package com.projeto1N.exemplo1N.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto1N.exemplo1N.Entity.Empresa;
import com.projeto1N.exemplo1N.Service.EmpresaService;

@Controller
@RequestMapping("/empresaCTR")
public class EmpresaController {
    
    private final EmpresaService oEmpresaService;

    public EmpresaController(EmpresaService oEmpresaService){
        this.oEmpresaService = oEmpresaService;
    }

    @GetMapping("/listarTodasEmpresas")
    public String listarTodasEmpresas(Model oModel){
        oModel.addAttribute("dadosEmpresa", oEmpresaService.listarEmpresas());
        return "listarEmpresa";
    }

    @GetMapping("/formCadastrar")
    public String showFormCad(Model oModel){
        oModel.addAttribute("empresa", new Empresa());
        return "cadastrarEmpresa";
    }

    @PostMapping("/cadastrarEmpresa")
    public String salvarEmpresa(@ModelAttribute Empresa oEmpresa){
        oEmpresaService.cadastrarEmpresa(oEmpresa);
        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable("id") Long id, Model oModel){
        Empresa empresaExistente = oEmpresaService.buscarEmpresaId(id).orElseThrow(
            () -> new IllegalArgumentException("Empresa não encontrada com o ID " + id));
        
        oModel.addAttribute("empresa", empresaExistente);
        return "cadastrarEmpresa";
    }

    @GetMapping("/excluir/{id}")
    public String excluirEmpresa(@PathVariable("id") Long id){
        oEmpresaService.deletarEmpresa(id);
        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

}
