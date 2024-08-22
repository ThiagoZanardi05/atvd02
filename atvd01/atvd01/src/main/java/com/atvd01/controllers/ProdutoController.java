package com.atvd01.controllers;

import com.atvd01.entities.ProdutoEntity;
import com.atvd01.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ProdutoEntity save(@RequestBody ProdutoEntity produto){
        return produtoService.save(produto);
    }

    @GetMapping("/findbyid/{id}")
    public ProdutoEntity findById(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @GetMapping("/findAll")
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        produtoService.delete(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/edit")
    public ProdutoEntity edit(@RequestBody ProdutoEntity produto){
        return produtoService.edit(produto);
    }

    @GetMapping("/top10")
    public List<ProdutoEntity> topDez(){
        return produtoService.topDez();
    }
}
