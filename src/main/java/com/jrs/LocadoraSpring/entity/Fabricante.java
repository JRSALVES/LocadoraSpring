package com.jrs.LocadoraSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {

    @Id
    private Long id;
    private String nome;
}
