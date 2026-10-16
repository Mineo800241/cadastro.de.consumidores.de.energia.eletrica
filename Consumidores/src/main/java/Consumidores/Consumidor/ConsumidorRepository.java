package Consumidores.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {

    List<Consumidor> findByNomeContainingIgnoreCase (String nome);
    Optional<Consumidor> findByMedidor(Long medidor);
    List<Consumidor> findByEmail (String email);
    Optional<Consumidor> findAllByTransformador(String transformador);
    List<Consumidor> findAllByChave(Integer chave);
    List<Consumidor> findAllByAlimentador(String alimentador);
    Optional<Consumidor> findById(Long uc);

}