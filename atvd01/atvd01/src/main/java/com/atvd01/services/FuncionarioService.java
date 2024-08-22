package com.atvd01.services;

import com.atvd01.entities.FuncionarioEntity;
import com.atvd01.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity save(FuncionarioEntity funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public FuncionarioEntity edit(FuncionarioEntity funcionario) {
        FuncionarioEntity funcionarioBase = findById(funcionario.getId());

        if(funcionarioBase != null) {
            if(funcionario.getNome() != null) {
                funcionarioBase.setNome(funcionario.getNome());
            }
            if(funcionario.getEmail() != null) {
                funcionarioBase.setEmail(funcionario.getEmail());
            }
            if(funcionario.getTelefone() != null) {
                funcionarioBase.setTelefone(funcionario.getTelefone());
            }
            if(funcionario.getIdade() != 0) {
                funcionarioBase.setIdade(funcionario.getIdade());
            }
            if(funcionario.getEndereco() != null) {
                funcionarioBase.setEndereco(funcionario.getEndereco());
            }
            if(funcionario.getFuncao() != null) {
                funcionarioBase.setFuncao(funcionario.getFuncao());
            }
            return funcionarioRepository.save(funcionarioBase);
        }
        return null;
    }

    public FuncionarioEntity findById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    public List<FuncionarioEntity> findAll() {
        return funcionarioRepository.findAll();
    }

    public void delete(Long id) {
        FuncionarioEntity funcionarioDelete = findById(id);
        funcionarioRepository.delete(funcionarioDelete);
    }
}
