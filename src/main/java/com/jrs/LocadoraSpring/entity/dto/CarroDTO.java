package com.jrs.LocadoraSpring.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {
    @Id
    private Long id;
    private String placa;
    private String cor;
    private boolean disponivel;
    private int ano;
}
