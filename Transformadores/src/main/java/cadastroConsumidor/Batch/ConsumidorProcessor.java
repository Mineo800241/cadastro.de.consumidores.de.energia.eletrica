package cadastroConsumidor.Batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorProcessor implements ItemProcessor<ConsumidorBatch, ConsumidorRequest> {

    private static final Logger log =
            LoggerFactory.getLogger(ConsumidorProcessor.class);

    @Override
    public ConsumidorRequest process(ConsumidorBatch consumidor) throws Exception {

        if(!consumidor.isSituacao()){
            log.info("Processor: consumidor desligado ignorado -> {}",consumidor);
            return null;
        }

        ConsumidorRequest processado = new ConsumidorRequest(
                null,
                consumidor.getNome().trim().toUpperCase(),
                consumidor.getEndereco().trim(),
                consumidor.getEmail().trim().toLowerCase(),
                consumidor.getMedidor(),
                consumidor.getTransformador().trim(),
                consumidor.getChave(),
                consumidor.getAlimentador().trim(),
                consumidor.isSituacao()
        );

        log.info("Processor: {} -> {}", consumidor, processado);

        return processado;
    }
}

