package com.projeto1N.exemplo1N.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto1N.exemplo1N.Entity.Funcionario;
import com.projeto1N.exemplo1N.Service.EmpresaService;
import com.projeto1N.exemplo1N.Service.FuncionarioService;

@Controller
@RequestMapping("/funcionarioCTR")
public class FuncionarioController {

    private final FuncionarioService oFuncionarioService;
    private final EmpresaService oEmpresaService;

    public FuncionarioController(
            FuncionarioService oFuncionarioService,
            EmpresaService oEmpresaService) {
        this.oFuncionarioService = oFuncionarioService;
        this.oEmpresaService = oEmpresaService;
    }

    @GetMapping("/formCadastrar")
    public String showFormCadastrar(Model oModel){
        oModel.addAttribute("funcionario", new Funcionario());
        oModel.addAttribute("empresas", oEmpresaService.listarEmpresas());

        return "cadastrarFuncionario";

    }

    @GetMapping("/listarAll")
    public String ListarTodosFunc(Model oModel){
        oModel.addAttribute("funcionarios",oFuncionarioService.listarTodosFunc()); 

        return "listarFuncionario";
    }
    @PostMapping ("/salvarFuncionario")
    public String cadastrarFuncionario(@ModelAttribute Funcionario oFuncionario)  {


        if(oFuncionario.getId_funcionario() != null) {
           oFuncionarioService.alterarFuncionario(
            oFuncionario.getId_funcionario(), oFuncionario);
        }
        else{
            oFuncionarioService.cadastrarFuncionario(oFuncionario);
        }
        oFuncionarioService.cadastrarFuncionario(oFuncionario);
       return "redirect:/funcionarioCTR/listarAll";

}

    @GetMapping("editarFunc/{id}")
    public String atualizarFuncionario(@PathVariable("id") Long id, Model oModel){
        
        Funcionario funcionarioExistente = oFuncionarioService.buscarFuncionarioId(id).orElseThrow(
            () -> new IllegalArgumentException("Funcionario não encontrado com o ID " + id));

        oModel.addAttribute("funcionario", funcionarioExistente);
        oModel.addAttribute("empresas",oEmpresaService.listarEmpresas());
        return "cadastrarFuncionario";
    }

    @GetMapping ("/deletarFunc/{id}")
    public String deletarFuncionario(@PathVariable("id") Long id){

        oFuncionarioService.deletarFuncionario(id);
        return "redirect:/funcionarioCTR/listarAll";
    }
}
