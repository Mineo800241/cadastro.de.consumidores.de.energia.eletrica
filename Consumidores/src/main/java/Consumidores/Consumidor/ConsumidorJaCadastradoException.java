package Consumidores.Consumidor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsumidorJaCadastradoException extends RuntimeException {
    public ConsumidorJaCadastradoException(String message) {
        super(message);
    }
}
