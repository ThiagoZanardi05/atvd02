package com.atvd01.controllers;

import com.atvd01.entities.ClienteEntity;
import com.atvd01.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ClienteEntity save(@RequestBody ClienteEntity cliente){
        return clienteService.save(cliente);
    }

    @GetMapping("/findbyid/{id}")
    public ClienteEntity findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @GetMapping("/findAll")
    public List<ClienteEntity> findAll(){
        return clienteService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        clienteService.delete(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/edit")
    public ClienteEntity edit(@RequestBody ClienteEntity cliente){
        return clienteService.edit(cliente);
    }
}
