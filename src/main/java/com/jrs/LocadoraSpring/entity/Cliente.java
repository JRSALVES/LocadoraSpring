package com.jrs.LocadoraSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate cnhVencimento;
    private String email;
    private String telefone;
    public int enderecoId;

}
