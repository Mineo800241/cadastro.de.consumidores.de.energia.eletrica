package cadastroConsumidor.Consumidor.client;
import cadastroConsumidor.Batch.ConsumidorRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "consumidor-service", url = "${consumidor.service.url}")
public interface ConsumidorClient {

        @GetMapping("/consumidores/{uc}")
        ConsumidorResponse buscarPorUc(@PathVariable("uc") Long uc);

        @PostMapping("/consumidores")
        void cadastrarConsumidor(@RequestBody ConsumidorRequest consumidor);
    }


