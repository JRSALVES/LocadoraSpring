package com.jrs.LocadoraSpring.service;


import com.jrs.LocadoraSpring.entity.Locacao;
import com.jrs.LocadoraSpring.repository.LocacaoRepositoryCuston;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepositoryCuston repositoryJdbcClient;

    public List<Locacao> findAllLocacao(){
        return repositoryJdbcClient.findAllLocacao();
    }

    public Locacao findLocacaoById(Long id){
        return repositoryJdbcClient.findLocacaoById(id);
    }

    public void createLocacao(Locacao locacao){
        repositoryJdbcClient.createLocacao(locacao);
    }

    public boolean deleteById(Long id){
        try{
            repositoryJdbcClient.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean updateLocacao(Locacao locacao){
        try{
            repositoryJdbcClient.updateLocacao(locacao);
            return true;
        }catch (Exception ex){
            return false;

        }
    }
}



