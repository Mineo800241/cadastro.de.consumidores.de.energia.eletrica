package cadastroConsumidor.Messaging;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    private final CadastroProducer cadastroProducer;

    public CadastroController(CadastroProducer cadastroProducer) {
        this.cadastroProducer = cadastroProducer;
    }

    @PostMapping
    public void enviar(@RequestBody CadastroMessage mensagem){
        cadastroProducer.enviar(mensagem);
    }
}
