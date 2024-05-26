package com.jrs.LocadoraSpring.repository.crudrepository;

import com.jrs.LocadoraSpring.entity.ModeloDTO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends CrudRepository<ModeloDTO, Long> {

    @Override
    List<ModeloDTO> findAll();

    @Modifying
    @Query("DELETE FROM modelo WHERE id = :?")
    public void deleteByID(@Param("?")Long id);
}
