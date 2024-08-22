package com.atvd01.controllers;

import com.atvd01.entities.ProdutoEntity;
import com.atvd01.entities.VendaEntity;
import com.atvd01.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public VendaEntity save(@RequestBody VendaEntity venda){
        return vendaService.save(venda);
    }

    @GetMapping("/findbyid/{id}")
    public VendaEntity findById(@PathVariable Long id){
        return vendaService.findById(id);
    }

    @GetMapping("/findAll")
    public List<VendaEntity> findAll(){
        return vendaService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        vendaService.delete(id);
        return "Deletado com sucesso!";
    }

    @GetMapping("/listarCliente/{nome}")
    public List<VendaEntity> listarCliente(@PathVariable String nome) {
        return  vendaService.listarCliente(nome);
    }

    @GetMapping("/listarFuncionario/{nome}")
    public List<VendaEntity> listarFuncionario(@PathVariable String nome) {
        return  vendaService.listarFuncionario(nome);
    }

    @GetMapping("/top10")
    public List<VendaEntity> topDez(){
        return vendaService.topDez();
    }
}
