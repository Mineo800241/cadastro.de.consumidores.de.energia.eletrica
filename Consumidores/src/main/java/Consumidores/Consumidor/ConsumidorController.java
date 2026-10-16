package Consumidores.Consumidor;

import Consumidores.Consumidor.dto.ConsumidorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumidores")
public class ConsumidorController {
    private final ConsumidorService consumidorService;

    public ConsumidorController(ConsumidorService consumidorService){
        this.consumidorService = consumidorService;
    }

    @PostMapping
    public ResponseEntity<ConsumidorResponse> cadastrarConsumidor(@Valid @RequestBody  Consumidor consumidor){

        ConsumidorResponse novoConsumidor = consumidorService.incluir(consumidor);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsumidor);
    }

    @GetMapping
    public ResponseEntity<List<ConsumidorResponse>> buscarTodos(){

        return ResponseEntity.ok(consumidorService.buscarTodos());
    }

    @GetMapping("/{uc}")
    public ResponseEntity<ConsumidorResponse> buscarPorUc(@PathVariable Long uc){

        return ResponseEntity.ok(consumidorService.buscarUc(uc));
    }

    @GetMapping("/medidor/{medidor}")
    public ResponseEntity<ConsumidorResponse> buscarMedidor(@PathVariable("medidor") Long medidor){
        return ResponseEntity.ok(consumidorService.buscarMedidor(medidor));
    }

//    @GetMapping("/trafo")
//    public List<Consumidor> buscarTrafo(String transformador){
//        return  consumidorService.buscarTransformador(transformador);
//    }

//    @GetMapping("/chave")
//    public List<Consumidor> buscarChave(@RequestParam int chave){
//
//        return  consumidorService.buscarChaves(chave);
//    }

//    @GetMapping("/alimentador")
//    public List<Consumidor> buscarAlimentador(String alimentador){
//        return consumidorService.buscarAlimentador(alimentador);
//    }

    @PutMapping("/{uc}")
    public ResponseEntity<ConsumidorResponse> alterar(@PathVariable Long uc, @Valid @RequestBody Consumidor consumidor){

        return ResponseEntity.ok(consumidorService.alterarCadastro(uc, consumidor));
    }

//    @PostMapping
//    public ResponseEntity<Consumidor> cadastrarConsumidor(@Valid @RequestBody Consumidor consumidor){
//        Consumidor novoConsumidor = consumidorService.incluir(consumidor);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoConsumidor);
//    }

}
