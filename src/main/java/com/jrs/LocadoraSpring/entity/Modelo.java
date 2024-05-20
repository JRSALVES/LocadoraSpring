package com.jrs.LocadoraSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    private Long id;
    private String nome;
    private int idFabricante;
}
