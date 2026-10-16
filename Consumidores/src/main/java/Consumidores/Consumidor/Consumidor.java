package Consumidores.Consumidor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consumidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uc;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @NotNull
    private Long medidor;

    private String transformador;

    @NotNull(message = "A chave é obrigatória")
    private Long chave;

    @NotBlank
    private String alimentador;


    private boolean situacao;

    public Consumidor(){

    }

    public Consumidor(Long uc, String nome, String endereco, String email, Long medidor, String transformador, Long chave, String alimentador, boolean situacao) {
        this.uc = uc;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.medidor = medidor;
        this.transformador = transformador;
        this.chave = chave;
        this.alimentador = alimentador;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return String.format("Consumidor{nome=%s,endereco=%s,email=%s,numerodaunidadeconsumidora=%s,medidor=%d,numeerodoTransformador=%s,numerodaChave=%d,alimentador=%s,situacao=%s}",
                nome,
                endereco,
                email,
                uc,
                medidor,
                transformador,
                chave,
                alimentador,
                situacao? "ligada":"desligada");
    }

    public Long getUc() {
        return uc;
    }

    public void setUc(Long uc) {
        this.uc = uc;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O endereço é obrigatório") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank(message = "O endereço é obrigatório") String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank(message = "O email é obrigatório") @Email(message = "O email deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório") @Email(message = "O email deve ser válido") String email) {
        this.email = email;
    }

    public @NotNull Long getMedidor() {
        return medidor;
    }

    public void setMedidor(@NotNull Long medidor) {
        this.medidor = medidor;
    }

    public String getTransformador() {
        return transformador;
    }

    public void setTransformador(String transformador) {
        this.transformador = transformador;
    }

    public @NotNull(message = "A chave é obrigatória") Long getChave() {
        return chave;
    }

    public void setChave(@NotNull(message = "A chave é obrigatória") Long chave) {
        this.chave = chave;
    }

    public @NotBlank String getAlimentador() {
        return alimentador;
    }

    public void setAlimentador(@NotBlank String alimentador) {
        this.alimentador = alimentador;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}


