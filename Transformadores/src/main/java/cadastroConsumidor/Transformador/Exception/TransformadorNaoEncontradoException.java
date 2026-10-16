package cadastroConsumidor.Transformador.Exception;

public class TransformadorNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TransformadorNaoEncontradoException(Long trafo){
        super("Transformador não encontrado. Trafo:" + trafo);
    }
}


