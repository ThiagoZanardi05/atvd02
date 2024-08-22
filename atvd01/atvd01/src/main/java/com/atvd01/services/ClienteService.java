package com.atvd01.services;

import com.atvd01.entities.ClienteEntity;
import com.atvd01.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity edit(ClienteEntity cliente) {
        ClienteEntity clienteBase = findById(cliente.getId());

        if(clienteBase != null) {
            if(cliente.getNome() != null) {
                clienteBase.setNome(cliente.getNome());
            }
            if(cliente.getEmail() != null) {
                clienteBase.setEmail(cliente.getEmail());
            }
            if(cliente.getTelefone() != null) {
                clienteBase.setTelefone(cliente.getTelefone());
            }
            if(cliente.getIdade() != 0) {
                clienteBase.setIdade(cliente.getIdade());
            }
            if(cliente.getEndereco() != null) {
                clienteBase.setEndereco(cliente.getEndereco());
            }
            return clienteRepository.save(clienteBase);
        }
        return null;
    }

    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public void delete(Long id) {
        ClienteEntity clienteDelete = findById(id);
        clienteRepository.delete(clienteDelete);
    }
}
