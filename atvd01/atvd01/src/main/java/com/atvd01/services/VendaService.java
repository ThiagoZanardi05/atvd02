package com.atvd01.services;

import com.atvd01.entities.ProdutoEntity;
import com.atvd01.entities.VendaEntity;
import com.atvd01.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaEntity save(VendaEntity venda) {
        float valorTotal = calcularValorTotal(venda);
        venda.setValorTotal(valorTotal);

        return vendaRepository.save(venda);
    }

    public VendaEntity findById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public List<VendaEntity> findAll() {
        return vendaRepository.findAll();
    }

    public void delete(Long id) {
        vendaRepository.deleteById(id);
    }

    private float calcularValorTotal(VendaEntity venda) {
        float valorTotal = 0.0f;
        for (ProdutoEntity produto : venda.getProdutos()) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public List<VendaEntity> listarCliente(String nome) {
        return vendaRepository.findByClienteNomeContaining(nome);
    }

    public List<VendaEntity> listarFuncionario(String nome) {
        return vendaRepository.findByFuncionarioNomeContaining(nome);
    }

    public List<VendaEntity> topDez() {
        return vendaRepository.findTop10ByOrderByValorTotalDesc();
    }

}
