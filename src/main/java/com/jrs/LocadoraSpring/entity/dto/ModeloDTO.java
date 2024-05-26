package com.jrs.LocadoraSpring.entity.dto;

import com.jrs.LocadoraSpring.entity.Fabricante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {

    @Id
    private Long id;
    private String nome;
    private Fabricante fabricante;
}
