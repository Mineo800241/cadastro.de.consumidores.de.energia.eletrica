package cadastroConsumidor.Transformador.dto;

import java.util.List;
import java.util.Set;

public record TransformadorResponse(Long trafo, String nome, Set<Long> consumidorIds) {

}
