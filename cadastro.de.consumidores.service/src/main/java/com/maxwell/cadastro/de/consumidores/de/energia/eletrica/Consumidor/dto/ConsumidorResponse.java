package com.maxwell.cadastro.de.consumidores.de.energia.eletrica.Consumidor.dto;

public record ConsumidorResponse(
        Long uc,
        String nome,
        String endereco,
        String email,
        Long medidor,
        String transformador,
        Long chave,
        String alimentador,
        boolean situacao) {
}








