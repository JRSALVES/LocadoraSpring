package com.jrs.LocadoraSpring.service;

import com.jrs.LocadoraSpring.entity.Cliente;
import com.jrs.LocadoraSpring.repository.crudrepository.ClienteRepository;
import com.jrs.LocadoraSpring.repository.ClienteRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;


    @Autowired
    ClienteRepositoryCustom repositoryJdbcClient;

    public List<Cliente> findAllClientes() {
        return repositoryJdbcClient.findAllClientes();
    }

    public Cliente findClienteById(Long id){
        return repositoryJdbcClient.findClienteById(id);
    }

    public void createCliente(Cliente cliente){
        repositoryJdbcClient.createCliente(cliente);
    }

    public boolean deleteById(Long id){
        try{
            repositoryJdbcClient.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public boolean updateCliente(Cliente cliente){
        try{
            repositoryJdbcClient.updateCliente(cliente);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}

