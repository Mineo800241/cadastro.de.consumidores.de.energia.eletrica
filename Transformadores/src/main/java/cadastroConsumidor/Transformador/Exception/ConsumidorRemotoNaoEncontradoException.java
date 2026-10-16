package cadastroConsumidor.Transformador.Exception;

public class ConsumidorRemotoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConsumidorRemotoNaoEncontradoException(Long consumidorID)
    {
        super("O Consumidor de UC " + consumidorID + " não foi encontrado no consumidor-service");
    }
}
