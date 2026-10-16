package Consumidores.Consumidor;

public class MedidorNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public MedidorNaoEncontradoException(int medidor) {
        super("Medidor não encontrado. Medidor:" + medidor);
    }
}
