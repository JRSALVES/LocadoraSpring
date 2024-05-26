package com.jrs.LocadoraSpring.service;

import com.jrs.LocadoraSpring.entity.dto.ModeloDTO;
import com.jrs.LocadoraSpring.repository.ModeloRepositoryCustom;
import com.jrs.LocadoraSpring.repository.crudrepository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository repository;

    @Autowired
    ModeloRepositoryCustom repositoryJdbcClient;

    public List<ModeloDTO> findAllModelos(){
        return repositoryJdbcClient.findAllModelos();
    }

    public ModeloDTO findModeloById(Long id){
        return repositoryJdbcClient.findModeloById(id);
    }

    public void createModelo(ModeloDTO modelo){
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

    public boolean updateModelo(ModeloDTO modelo){
        try{
            repositoryJdbcClient.updateModelo(modelo);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
