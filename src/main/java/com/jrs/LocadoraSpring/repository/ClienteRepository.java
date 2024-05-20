package com.jrs.LocadoraSpring.repository;

import com.jrs.LocadoraSpring.entity.Cliente;
import com.jrs.LocadoraSpring.entity.Modelo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Override
    List<Cliente> findAll();

    @Modifying
    @Query("DELETE FROM cliente WHERE id = :?")
    public void deleteByID(@Param("?")Long id);
}
