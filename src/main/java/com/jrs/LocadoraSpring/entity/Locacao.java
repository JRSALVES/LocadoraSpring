package com.jrs.LocadoraSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

    @Id
    private Long id;
    private Long seguradoraId;
    private Long carroId;
    private Long clienteId;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvida;
    private Double valorDesconto;
    private Double valor;
    private Double valorTotal;

}


