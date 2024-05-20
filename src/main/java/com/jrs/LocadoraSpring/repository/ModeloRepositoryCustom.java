package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModeloRepositoryCustom {

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<Modelo> modeloRowMapper = (rs, rowNum) -> {
        Modelo modelo = new Modelo();
        modelo.setId(rs.getLong("id"));
        modelo.setNome(rs.getString("nome"));
        modelo.setIdFabricante(rs.getInt("fabricante_id"));
        return modelo;
    };

    public List<Modelo> findAllModelos() {
        String sql = "SELECT * FROM modelo";
        return jdbcClient
                .sql(sql)
                .query(modeloRowMapper)
                .list();
    }

    public Modelo findModeloById(Long id) {
        String sql = "SELECT * FROM modelo WHERE id = ?";
        return jdbcClient
                .sql(sql)
                .param(id)
                .query(modeloRowMapper)
                .single();
    }

    public Integer create(Modelo modelo) {
        String sql = "INSERT INTO modelo (nome, fabricante_id) VALUES (:nome, :fabricante_id)";
        return jdbcClient
                .sql(sql)
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getIdFabricante())
                .update();
    }

    public Integer deleteById(Long id) {
        String sql = "DELETE FROM modelo WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }

    public Integer updateModelo(Modelo modelo) {
        String sql = "UPDATE modelo SET nome = :nome, fabricante_id = :fabricante_id WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("nome", modelo.getNome())
                .param("fabricante_id", modelo.getIdFabricante())
                .param("id", modelo.getId())
                .update();
    }
}
