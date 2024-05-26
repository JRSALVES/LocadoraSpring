package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Fabricante;
import com.jrs.LocadoraSpring.entity.dto.ModeloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModeloRepositoryCustom {

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<ModeloDTO> modeloDTORowMapper = (rs, rowNum) -> {
        ModeloDTO modelo = new ModeloDTO();
        modelo.setId(rs.getLong("id"));
        modelo.setNome(rs.getString("nome"));

        Fabricante fabricante = new Fabricante();
        fabricante.setId(rs.getLong("idFabricante"));
        fabricante.setNome(rs.getString("nome"));

        modelo.setFabricante(fabricante);
        return modelo;
    };

    public List<ModeloDTO> findAllModelos() {
        String sql = "SELECT * FROM modelo";
        return jdbcClient
                .sql(sql)
                .query(modeloDTORowMapper)
                .list();
    }

    public ModeloDTO findModeloById(Long id) {
        String sql = "SELECT * FROM modelo WHERE id = ?";
        return jdbcClient
                .sql(sql)
                .param(id)
                .query(modeloDTORowMapper)
                .single();
    }

    public Integer create(ModeloDTO modelo) {
        String sql = "INSERT INTO modelo (nome, fabricante_id) VALUES (:nome, :fabricante_id)";
        return jdbcClient
                .sql(sql)
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getFabricante())
                .update();
    }

    public Integer deleteById(Long id) {
        String sql = "DELETE FROM modelo WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }

    public Integer updateModelo(ModeloDTO modelo) {
        String sql = "UPDATE modelo SET nome = :nome, fabricante_id = :fabricante_id WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getFabricante())
                .param("id", modelo.getId())
                .update();
    }
}
