package com.maxwell.cadastro.de.consumidores.de.energia.eletrica.Consumidor;

public class ConsumidorNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ConsumidorNaoEncontradoException(Long uc){
        super("Unidade Consumidora não encontrado. UC:" + uc);
    }
}
