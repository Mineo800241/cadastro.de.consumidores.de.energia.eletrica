package cadastroConsumidor.Transformador;

import cadastroConsumidor.Transformador.dto.TransformadorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transformadores")
public class TransformadorController {

    private final TransformadorService transformadorService;

    public TransformadorController(TransformadorService transformadorService) {
        this.transformadorService = transformadorService;
    }

    @GetMapping("/{trafo}/detalhes")
    public ResponseEntity<TransformadorResponse> obterDetalhes(@PathVariable Long trafo){

        TransformadorResponse transformadorResponse = transformadorService.obterDetalhes(trafo);

        return ResponseEntity.ok(transformadorResponse);
    }

    // POST /transformadores/{transformadorId}/consumidores/{consumidorId}
    @PostMapping("/{transformadorId}/consumidores/{consumidorId}")
    public ResponseEntity<TransformadorResponse> cadastrarConsumidor(@PathVariable  Long transformadorId, @PathVariable Long consumidorId){
        TransformadorResponse cadastrarUcNoTrafo =   transformadorService.cadastrarConsumidor(transformadorId,consumidorId);
        return ResponseEntity.ok(cadastrarUcNoTrafo);
    }
    // localhost:8080/transformador/1/consumidor/1;

    // POST /transformadores
    @PostMapping
    public ResponseEntity<Transformador> incluirTransformador(@Valid @RequestBody Transformador transformador){
        return ResponseEntity.status(HttpStatus.CREATED).body(transformadorService.incluirTransformador(transformador));
    }

    // GET /transformadores
    @GetMapping
    public ResponseEntity<List<Transformador>> obterListaTransformador(){
        return ResponseEntity.ok(transformadorService.obterListaTransformador());
    }

    @GetMapping("/{trafoId}")
    public ResponseEntity<Transformador> obterPorTrafo(@PathVariable long trafoId){
        return ResponseEntity.ok(transformadorService.buscarTransformador(trafoId));
    }

    // PUT /transformadores/{trafoId}
    @PutMapping("/{trafoId}")
    public ResponseEntity<Transformador> alterarTransformador(@PathVariable long trafoId, @Valid @RequestBody Transformador transformador){
        return ResponseEntity.ok(transformadorService.alterarTransformador(trafoId,transformador));
    }



}
