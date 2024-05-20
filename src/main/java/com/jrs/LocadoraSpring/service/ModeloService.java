package com.jrs.LocadoraSpring.service;

import com.jrs.LocadoraSpring.entity.Modelo;
import com.jrs.LocadoraSpring.repository.ModeloRepository;
import com.jrs.LocadoraSpring.repository.ModeloRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository repository;

    @Autowired
    ModeloRepositoryCustom repositoryJdbcClient;

    public List<Modelo> findAllModelos(){
        return repositoryJdbcClient.findAllModelos();
    }

    public Modelo findModeloById(Long id){
        return repositoryJdbcClient.findModeloById(id);
    }

    public void createModelo(Modelo modelo){
        repositoryJdbcClient.create(modelo);
    }

    public boolean deleteById(Long id){
        try{
            repositoryJdbcClient.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public boolean updateModelo(Modelo modelo){
        try{
            repositoryJdbcClient.updateModelo(modelo);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
