package Consumidores.Consumidor.dto;

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








