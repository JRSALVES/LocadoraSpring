package com.jrs.LocadoraSpring.service;

import com.jrs.LocadoraSpring.entity.Fabricante;
import com.jrs.LocadoraSpring.repository.crudrepository.FabricanteRepository;
import com.jrs.LocadoraSpring.repository.FabricanteRepositoryCuston;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    FabricanteRepository repository;

    @Autowired
    FabricanteRepositoryCuston repositoryJdbcClient;


    public List<Fabricante> findAllFabricantes() {
        Fabricante fabricante = new Fabricante();
        return repository.findAll();
    }

    public Fabricante findFabricanteById(Long id) {
        return repositoryJdbcClient.findFabricanteById(id);
    }

    public void insertFabricante(String nome) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(nome);
        repository.save(fabricante);
    }


    public boolean deleteById(Long id) {
        try {
            repository.deleteByID(id);
            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateFabricante(Fabricante fabricante) {
        try {
            repository.save(fabricante);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
