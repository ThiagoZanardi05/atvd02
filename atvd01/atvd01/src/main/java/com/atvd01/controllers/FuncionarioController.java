package com.atvd01.controllers;

import com.atvd01.entities.FuncionarioEntity;
import com.atvd01.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public FuncionarioEntity save(@RequestBody FuncionarioEntity funcionario){
        return funcionarioService.save(funcionario);
    }

    @GetMapping("/findbyid/{id}")
    public FuncionarioEntity findById(@PathVariable Long id){
        return funcionarioService.findById(id);
    }

    @GetMapping("/findAll")
    public List<FuncionarioEntity> findAll(){
        return funcionarioService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        funcionarioService.delete(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/edit")
    public FuncionarioEntity edit(@RequestBody FuncionarioEntity funcionario){
        return funcionarioService.edit(funcionario);
    }
}
