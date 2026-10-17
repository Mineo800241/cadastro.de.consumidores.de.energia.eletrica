package cadastroConsumidor.Messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CadastroConsumer {

    @RabbitListener(queues = "cadastros")
    public void receber(CadastroMessage mensagem){
        System.out.println("[MENSAGEM RECEBIDA]" + mensagem);
    }

}
