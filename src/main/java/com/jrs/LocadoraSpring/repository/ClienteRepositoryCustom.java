package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class ClienteRepositoryCustom {

    @Autowired
    JdbcClient jdbcClient;

    RowMapper<Cliente> clienteRowMapper =(rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setRg(rs.getString("rg"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setCnh(rs.getString("cnh"));
            cliente.setCnhVencimento(rs.getDate("cnh_vencimento").toLocalDate());
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEnderecoId(rs.getInt("endereco_id"));
            return cliente;
        };


    public List<Cliente> findAllClientes() {
        String sql = "SELECT * FROM cliente";
        return jdbcClient
                .sql(sql)
                .query(clienteRowMapper)
                .list();
    }


    public Cliente findClienteById(Long id){
        String sql = "SELECT * FROM cliente WHERE id  = ?";
        return jdbcClient
                .sql(sql)
                .param(id)
                .query(clienteRowMapper)
                .single();
    }

    public Integer createCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, rg, cpf, cnh, cnh_vencimento, email, telefone, endereco_id) VALUES " +
                "(:nome, :rg, :cpf, :cnh, :cnh_vencimento, :email, :telefone, :endereco_id)";
        return jdbcClient
                .sql(sql)
                .param("nome", cliente.getNome())
                .param("rg", cliente.getRg())
                .param("cpf", cliente.getCpf())
                .param("cnh", cliente.getCnh())
                .param("cnh_vencimento", Date.valueOf(cliente.getCnhVencimento()))
                .param("email", cliente.getEmail())
                .param("telefone", cliente.getTelefone())
                .param("endereco_id", cliente.getEnderecoId())
                .update();
    }


    public Integer deleteById(Long id){
        String sql = "DELETE FORM cliente WHERE id = :id";
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }


    public Integer updateCliente( Cliente cliente){
        String sql = "UPDATE cliente SET nome =:nome, rg =:rg, cpf =:cpf, cnh =:cnh, cnh_vencimento =:cnh-vencimento, " +
                "email =:email, telefone =:telefone, endereco_id =:endereco_id";
        return jdbcClient
                .sql(sql)
                .param("nome", cliente.getNome())
                .param("rg", cliente.getRg())
                .param("cpf", cliente.getCpf())
                .param("cnh", cliente.getCnh())
                .param("cnh_vencimento", Date.valueOf(cliente.getCnhVencimento()))
                .param("email", cliente.getEmail())
                .param("telefone", cliente.getTelefone())
                .param("endereco_id", cliente.getEnderecoId())
                .update();
    }

}
