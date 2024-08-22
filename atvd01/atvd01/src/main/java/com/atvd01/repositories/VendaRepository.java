package com.atvd01.repositories;

import com.atvd01.entities.ProdutoEntity;
import com.atvd01.entities.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

    List<VendaEntity> findByClienteNomeContaining(String nomeCliente);
    List<VendaEntity> findByFuncionarioNomeContaining(String nomeFuncionario);
    List<VendaEntity> findTop10ByOrderByValorTotalDesc();
}
