package com.jrs.LocadoraSpring.repository.crudrepository;

import com.jrs.LocadoraSpring.entity.Carro;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractRepository <ENTITY>{

    protected JdbcClient jdbcClient;

    public AbstractRepository(JdbcClient jdbcClient){this.jdbcClient = jdbcClient;}

    public abstract List<?> getAll(Object filter);

    public abstract List <Carro> getAll();

    public abstract Optional<?>getByID(Integer id);

    public abstract boolean existsByID(Integer id);

    public abstract Integer create(ENTITY entity);

    public abstract Integer update(ENTITY entity);

    public abstract Integer delete(Integer id);
}
