package cadastroConsumidor.Transformador.Exception;

public class ConsumidorServiceIndisponivelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConsumidorServiceIndisponivelException() {

        super("Não foi possível acessar o consumidor-service.");
    }
}
