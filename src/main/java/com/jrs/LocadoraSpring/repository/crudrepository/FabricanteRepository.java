package com.jrs.LocadoraSpring.repository.crudrepository;


import com.jrs.LocadoraSpring.entity.Fabricante;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Long> {

    @Override
    List<Fabricante> findAll();

    @Modifying
    @Query("DELETE FROM fabricante WHERE id = :?")
    public void deleteByID(@Param("?")Long id);

}
