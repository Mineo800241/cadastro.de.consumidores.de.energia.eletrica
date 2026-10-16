package cadastroConsumidor.Transformador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {

    List<Transformador> findByNameContainingIgnoreCase (String name);
    Optional<Transformador> findByName(String name);
  //  List<Transformador> findByListaConsumidoresIsNotEmpty();
  //  @Query("SELECT COUNT(c) FROM Transformador t JOIN t.listaConsumidores c WHERE t.trafo = :transformadorId")
  //  long countConsumidoresByTransformadorId(@Param("transformadorId") Long transformadorId);
}
