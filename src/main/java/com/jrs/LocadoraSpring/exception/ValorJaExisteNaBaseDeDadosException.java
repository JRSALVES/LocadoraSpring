package com.jrs.LocadoraSpring.exception;

public class ValorJaExisteNaBaseDeDadosException extends AbtractMinhaException{

        public ValorJaExisteNaBaseDeDadosException() {super("Valor já existente na Base de Dados");}
}
