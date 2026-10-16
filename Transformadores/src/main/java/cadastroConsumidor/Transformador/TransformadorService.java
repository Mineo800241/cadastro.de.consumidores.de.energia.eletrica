package cadastroConsumidor.Transformador;
import cadastroConsumidor.Transformador.Exception.TransformadorNaoEncontradoException;
import cadastroConsumidor.Transformador.dto.TransformadorResponse;
import cadastroConsumidor.Consumidor.client.ConsumidorGateway;
import cadastroConsumidor.Consumidor.client.ConsumidorResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransformadorService {

    private final TransformadorRepository transformadorRepository;
    private final ConsumidorGateway consumidorGateway;

    public TransformadorService(TransformadorRepository transformadorRepository, ConsumidorGateway consumidorGateway) {
        this.transformadorRepository = transformadorRepository;
        this.consumidorGateway = consumidorGateway;
    }

    public TransformadorResponse obterDetalhes(Long trafo){
        Transformador transformador = buscarTransformador(trafo);
        return converterParaResponse(transformador);
    }


    @Transactional
    public TransformadorResponse cadastrarConsumidor(Long transformadorID, Long consumidorID){

        Transformador transformador = obterEntidadePorUc(transformadorID);

        ConsumidorResponse consumidor = consumidorGateway.buscarPorUc(consumidorID);

        if(transformador.getConsumidorIds().contains(consumidor.uc())){
            throw new IllegalArgumentException("O Consumidor com UC " + consumidorID + " já está cadastrado neste Transformador.");
        }

             transformador.adicionarConsumidor(consumidor.uc());

        Transformador transformadorAtualizado = transformadorRepository.save(transformador);

        return converterParaResponse(transformadorAtualizado);
    }

    @Transactional
    public  Transformador incluirTransformador(Transformador transformador){
        return transformadorRepository.save(transformador);
    }

    public List<Transformador> obterListaTransformador(){

        return transformadorRepository.findAll();
    }

    public Transformador buscarTransformador(Long trafo){
        return transformadorRepository.findById(trafo).orElseThrow(() -> new TransformadorNaoEncontradoException(trafo));

    }

    @Transactional
    public Transformador alterarTransformador(Long trafo, Transformador transformadorAtualizado){
        Transformador transformadorExistente = buscarTransformador(trafo);
        transformadorExistente.setName(transformadorAtualizado.getName());
        return transformadorRepository.save(transformadorExistente);
    }

    @Transactional
    public void excluirTransformador(Long trafo){
        Transformador transformador = buscarTransformador(trafo);
        transformadorRepository.delete(transformador);
    }

    private Transformador obterEntidadePorUc(Long trafo){
        return transformadorRepository
                .findById(trafo)
                .orElseThrow(()->
                        new TransformadorNaoEncontradoException(trafo)
                        );
    }

    private TransformadorResponse converterParaResponse(Transformador transformador){

        return new TransformadorResponse(transformador.getId(),
                transformador.getName(),
                transformador.getConsumidorIds()
        );
    }

}
