package cadastroConsumidor.Transformador;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transformador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trafo;

    @NotBlank(message = "Número do transformador é obrigatório")
    private String name;


    @ElementCollection
    @CollectionTable(name="transformador_consumidor",joinColumns = @JoinColumn(name = "transformador_id") )
    @Column(name = "consumidor_id")
    private Set<Long> consumidorIds = new HashSet<Long>();



    public Transformador(){

    }

    public Transformador(Long trafo, String name) {
        this.trafo = trafo;
        this.name = name;
    }

    public void adicionarConsumidor(Long consumidorId) {

        consumidorIds.add(consumidorId);
    }


    public Long getId() {
        return trafo;
    }

    public void setId(Long id) {
        this.trafo = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getConsumidorIds() {
        return consumidorIds;
    }
}




