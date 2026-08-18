package com.projeto1N.exemplo1N.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Empresa;
import com.projeto1N.exemplo1N.Repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    private final EmpresaRepository oEmpresaRepository;

    public EmpresaService(EmpresaRepository oEmpresaRepository) {
        this.oEmpresaRepository = oEmpresaRepository;
    }
    
    public List<Empresa> listarEmpresas() {
        return oEmpresaRepository.findAll();
    }

    public Optional<Empresa> buscarEmpresaId(Long id){
        return oEmpresaRepository.findById(id);
    }

    public Empresa cadastrarEmpresa(Empresa oEmpresa){
        return oEmpresaRepository.save(oEmpresa);
    }

    public Empresa alterarEmpresa(Long id, Empresa dadosAlterados){
        Empresa empresaExistente = oEmpresaRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Empresa não encontrada com o ID " + id));
        
        empresaExistente.setNome_empresa(dadosAlterados.getNome_empresa());
        empresaExistente.setCnpj_empresa(dadosAlterados.getCnpj_empresa());
        empresaExistente.setRamo_empresa(dadosAlterados.getRamo_empresa());

        return oEmpresaRepository.save(empresaExistente);

    }

    public void deletarEmpresa(Long id) {
        Empresa empresaExcluir = buscarEmpresaId(id).orElseThrow(
            () -> new IllegalArgumentException("Empresa não encontrada com ID " + id));
        
        oEmpresaRepository.delete(empresaExcluir);

    }

}