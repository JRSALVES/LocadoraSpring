package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Locacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class LocacaoRepositoryCuston {

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<Locacao> locacaoRowMapper = (rs, rowNum) -> {
        Locacao locacao = new Locacao();
        locacao.setId(rs.getLong("id"));
        locacao.setSeguradoraId(rs.getLong("seguradora_id"));
        locacao.setCarroId(rs.getLong("carro_id"));
        locacao.setClienteId(rs.getLong("cliente_id"));
        locacao.setDataLocacao(rs.getDate("datalocacao").toLocalDate());
        locacao.setDataDevolucao(rs.getDate("datadevolucao").toLocalDate());
        locacao.setDataDevolvida(rs.getDate("datadevolvida").toLocalDate());
        locacao.setValorDesconto(rs.getDouble("valordesconto"));
        locacao.setValor(rs.getDouble("valor"));
        locacao.setValorTotal(rs.getDouble("valortotal"));

        return locacao;
    };

    public List<Locacao> findAllLocacao() {
        String sql = "SELECT * FROM locacao";
        return jdbcClient
                .sql(sql)
                .query(locacaoRowMapper)
                .list();
    }

    public Locacao findLocacaoById(Long id) {
        String sql = "SELECT * FROM locacao WHERE id = ?";
        return jdbcClient
                .sql(sql)
                .param(id)
                .query(locacaoRowMapper)
                .single();
    }

    public Integer createLocacao(Locacao locacao) {
        String sql = "INSERT INTO locacao (seguradora_id, carro_id, cliente_id, datalocacao, datadevolucao, datadevolvida, " +
                "valordesconto, valor, valortotal) VALUES (:seguradora_id, :carro_id, :cliente_id, :datalocacao, :datadevolucao, :datadevolvida, :valordesconto, :valor, :valortotal)";
        return jdbcClient
                .sql(sql)
                .param("seguradora_id", locacao.getSeguradoraId())
                .param("carro_id", locacao.getCarroId())
                .param("cliente_id", locacao.getClienteId())
                .param("datalocacao", Date.valueOf(locacao.getDataLocacao()))
                .param("datadevolucao", Date.valueOf(locacao.getDataDevolucao()))
                .param("datadevolvida", Date.valueOf(locacao.getDataDevolvida()))
                .param("valordesconto", locacao.getValorDesconto())
                .param("valor", locacao.getValor())
                .param("valortotal", locacao.getValorTotal())
                .update();
    }

    public Integer deleteById(Long id) {
        String sql = "DELETE FROM locacao WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }

    public Integer updateLocacao(Locacao locacao) {
        String sql = "UPDATE locacao SET seguradora_id = :seguradora_id, carro_id = :carro_id, cliente_id = :cliente_id, " +
                "datalocacao = :datalocacao, datadevolucao = :datadevolucao, datadevolvida = :datadevolvida, valordesconto = :valordesconto, " +
                "valor = :valor, valortotal = :valortotal WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("seguradora_id", locacao.getSeguradoraId())
                .param("carro_id", locacao.getCarroId())
                .param("cliente_id", locacao.getClienteId())
                .param("datalocacao", Date.valueOf(locacao.getDataLocacao()))
                .param("datadevolucao", Date.valueOf(locacao.getDataDevolucao()))
                .param("datadevolvida", Date.valueOf(locacao.getDataDevolvida()))
                .param("valordesconto", locacao.getValorDesconto())
                .param("valor", locacao.getValor())
                .param("valortotal", locacao.getValorTotal())
                .param("id", locacao.getId())
                .update();
    }
}


