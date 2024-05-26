package com.jrs.LocadoraSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    private Long id;
    private Long fabricante_id;
    private Long modelo_id;
    private int ano;
    private String cor;
    private String placa;
    private Double valorLocacao;
    private Boolean disponivel;
}
