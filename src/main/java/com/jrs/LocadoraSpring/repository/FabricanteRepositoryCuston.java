package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FabricanteRepositoryCuston{

    @Autowired
    JdbcClient jdbcClient;

        RowMapper<Fabricante> fabricanteRowMapper = (rs, rowNum) -> {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getLong("id"));
            fabricante.setNome(rs.getString("nome"));

            return fabricante;
        };

    public List<Fabricante> findAllFabricantes(){
    return jdbcClient
            .sql("SELECT * FROM fabricante")
            .query(fabricanteRowMapper)
            .list();
    }

    public Fabricante findFabricanteById(Long id){
        String sql = "SELECT * FROM fabricante WHERE id = ?";
        return jdbcClient
                .sql(sql)
                .param(id)
                .query(fabricanteRowMapper)
                .single();
    }

    public Integer create(Fabricante fabricante) {
        return jdbcClient
                .sql("INSERT INTO fabricante (nome) VALUES (:nome)")
                .param("nome", fabricante.getNome())
                .update();
    }

    public Integer delete(Long id) {
        return jdbcClient.sql("DELETE FROM fabricante WHERE id = :id")
                .param("id", id)
                .update();
    }

    public Integer update(Fabricante fabricante) {
        return jdbcClient
                .sql("UPDATE fabricante SET nome = :nome WHERE id = :id")
                .param("nome", fabricante.getNome())
                .param("id", fabricante.getId())
                .update();
    }
}
