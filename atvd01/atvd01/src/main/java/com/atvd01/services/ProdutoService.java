package com.atvd01.services;

import com.atvd01.entities.ProdutoEntity;
import com.atvd01.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity save(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    public ProdutoEntity edit(ProdutoEntity produto) {
        ProdutoEntity produtoBase = findById(produto.getId());

        if(produtoBase != null) {
            if(produto.getNome() != null) {
                produtoBase.setNome(produto.getNome());
            }
            if(produto.getDescricao() != null) {
                produtoBase.setDescricao(produto.getDescricao());
            }
            if (produto.getPreco() != 0) {
                produtoBase.setPreco(produto.getPreco());
            }
            return produtoRepository.save(produtoBase);
        }
        return null;
    }

    public ProdutoEntity findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        ProdutoEntity produtoDelete = findById(id);
        produtoRepository.delete(produtoDelete);
    }

    public List<ProdutoEntity> topDez() {
        return produtoRepository.findTop10ByOrderByPrecoDesc();
    }
}
