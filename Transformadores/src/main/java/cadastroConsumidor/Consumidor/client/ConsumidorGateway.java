package cadastroConsumidor.Consumidor.client;

import cadastroConsumidor.Transformador.Exception.ConsumidorRemotoNaoEncontradoException;
import cadastroConsumidor.Transformador.Exception.ConsumidorServiceIndisponivelException;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ConsumidorGateway {

    private final ConsumidorClient consumidorClient;

    public ConsumidorGateway(ConsumidorClient consumidorClient) {
        this.consumidorClient = consumidorClient;
    }

    public ConsumidorResponse buscarPorUc(@PathVariable("uc") Long uc) {
        try {
            return consumidorClient.buscarPorUc(uc);
        } catch (FeignException.NotFound e) {
            throw new ConsumidorRemotoNaoEncontradoException(uc);
        } catch (RetryableException e) {
            throw new ConsumidorServiceIndisponivelException();
        }
    }
    }
