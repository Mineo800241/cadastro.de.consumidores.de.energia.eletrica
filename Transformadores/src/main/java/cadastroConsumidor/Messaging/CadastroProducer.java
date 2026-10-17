package cadastroConsumidor.Messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CadastroProducer {

    private final RabbitTemplate rabbitTemplate;

    public CadastroProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(CadastroMessage mensagem){

        rabbitTemplate.convertAndSend("cadastros", mensagem);

        System.out.println("[MENSAGEM ENVIADA] " + mensagem);

    }
}
