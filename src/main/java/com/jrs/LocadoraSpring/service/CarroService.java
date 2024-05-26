package com.jrs.LocadoraSpring.service;


import com.jrs.LocadoraSpring.entity.dto.CarroDTO;
import com.jrs.LocadoraSpring.repository.CarroRepositoryCuston;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarroService {

    @Autowired
    CarroRepositoryCuston repositoryJdbcClient;


}
