package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Carro;
import com.jrs.LocadoraSpring.entity.Fabricante;
import com.jrs.LocadoraSpring.entity.dto.CarroDTO;
import com.jrs.LocadoraSpring.entity.dto.ModeloDTO;
import com.jrs.LocadoraSpring.repository.crudrepository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarroRepositoryCuston extends AbstractRepository<Carro>{

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<CarroDTO> carroDTORowMapper = (rs, rowNum) -> {
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(rs.getLong("id"));
        carroDTO.setPlaca(rs.getString("placa"));
        carroDTO.setCor(rs.getString("cor"));
        carroDTO.setDisponivel(rs.getBoolean("disponivel"));
        carroDTO.setAno(rs.getInt("ano"));

        Fabricante fabricante = new Fabricante();
        fabricante.setId(rs.getLong("idFabricante"));
        fabricante.setNome(rs.getString("nome"));

        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(rs.getLong("id"));
        modeloDTO.setNome(rs.getString("nome"));

        return carroDTO;
    };

    @Override
    public List<?> getAll(Object filter) {
        return List.of();
    }

    @Override
    public List<Carro> getAll() {
        return List.of();
    }

    @Override
    public Optional<?> getByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByID(Integer id) {
        return false;
    }

    @Override
    public Integer create(Carro carro) {
        return 0;
    }

    @Override
    public Integer update(Carro carro) {
        return 0;
    }

    @Override
    public Integer delete(Integer id) {
        return 0;
    }
}
