package cadastroConsumidor.Batch;

public class ConsumidorRequest{
    private Long uc;
    private String nome;
    private String endereco;
    private String email;
    private Long medidor;
    private String transformador;
    private Long chave;
    private String alimentador;
    private boolean situacao;

    public ConsumidorRequest(){

    }

    public ConsumidorRequest(Long uc,String nome, String endereco, String email, Long medidor, String transformador, Long chave, String alimentador, boolean situacao) {
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

    public Long getUc() {
        return uc;
    }

    public void setUc(Long uc) {
        this.uc = uc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMedidor() {
        return medidor;
    }

    public void setMedidor(Long medidor) {
        this.medidor = medidor;
    }

    public String getTransformador() {
        return transformador;
    }

    public void setTransformador(String transformador) {
        this.transformador = transformador;
    }

    public Long getChave() {
        return chave;
    }

    public void setChave(Long chave) {
        this.chave = chave;
    }

    public String getAlimentador() {
        return alimentador;
    }

    public void setAlimentador(String alimentador) {
        this.alimentador = alimentador;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
