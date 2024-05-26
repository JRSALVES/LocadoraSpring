package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Carro;
import com.jrs.LocadoraSpring.repository.crudrepository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public abstract class CarroRepository extends AbstractRepository<Carro> {

    RowMapper<Carro> carroRowMapper = (rs, rowNum) -> {
        Carro carro = new Carro();
        carro.setId(rs.getLong("id"));
        carro.setFabricante_id(rs.getLong("fabricante_id"));
        carro.setModelo_id(rs.getLong("modelo_id"));
        carro.setCor(rs.getString("cor"));
        carro.setPlaca(rs.getString("placa"));
        carro.setAno(rs.getInt("ano"));
        carro.setValorLocacao(rs.getDouble("valorLocacao"));
        carro.setDisponivel(rs.getBoolean("disponivel"));

        return carro;
    };

    @Autowired
    public CarroRepository(JdbcClient jdbcClient) {
        super(jdbcClient);
    }

    @Override
    public List <Carro> getAll( ) {
    String sql = "SELECT * FROM carro";
    return jdbcClient
            .sql(sql)
            .query(carroRowMapper)
            .list();
    }

    @Override
    public Optional<Carro> getByID(Integer id) {
        String sql = "SELECT * FROM carro WHERE id = :idCarro";
        return jdbcClient
                .sql(sql)
                .param("idCarro", id)
                .query(carroRowMapper)
                .optional();
        }

    @Override
    public boolean existsByID(Integer id) {
        throw new RuntimeException("METODO AINDA NÃO IMPLEMENTADO");
    }

    @Override
    public Integer create(Carro carro) {
        String sql = "INSERT INTO carro(fabricante_id, model_id, ano, placa, valorLocacao, disponivel) VALUES(:fabircante_id," +
                " :modelo_id, :ano, :placa, :valorLocacao, :disponivel)";

        return jdbcClient
                .sql(sql)
                .param("fabricante_id", carro.getFabricante_id())
                .param("modelo_id", carro.getModelo_id())
                .param("ano", carro.getAno())
                .param("cor", carro.getCor())
                .param("placa", carro.getPlaca())
                .param("valorLocacao", carro.getValorLocacao())
                .param("disponivel", carro.getDisponivel())
                .update();
    }

    @Override
    public Integer update(Carro carro) {
        String sql = "UPDATE carro SET fabricante_id =:fabricante_id, modelo_id =:modelo_id, ano =:ano, placa =:placa, " +
                "valorLcacao =:valorLocacao, disponivel =:disponivel";

        return jdbcClient
                .sql(sql)
                .param("fabricante_id", carro.getFabricante_id())
                .param("modelo_id", carro.getModelo_id())
                .param("ano", carro.getAno())
                .param("cor", carro.getCor())
                .param("placa", carro.getPlaca())
                .param("valorLocacao", carro.getValorLocacao())
                .param("disponivel", carro.getDisponivel())
                .update();
    }

    @Override
    public Integer delete(Integer id) {
        String sql = "DELETE FROM carro WHERE id = id";

        return jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }
}
