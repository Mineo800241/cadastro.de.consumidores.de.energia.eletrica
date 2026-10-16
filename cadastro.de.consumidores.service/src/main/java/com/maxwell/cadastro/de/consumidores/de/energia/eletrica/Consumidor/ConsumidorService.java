package com.maxwell.cadastro.de.consumidores.de.energia.eletrica.Consumidor;

import com.maxwell.cadastro.de.consumidores.de.energia.eletrica.Consumidor.dto.ConsumidorResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ConsumidorService {

    private final ConsumidorRepository consumidorRepository;

    public ConsumidorService(ConsumidorRepository consumidorRepository){
        this.consumidorRepository = consumidorRepository;
    }
    public ConsumidorResponse incluir(Consumidor consumidor){

        Consumidor consumidorIncluido = consumidorRepository.save(consumidor);

        return converterParaResponse(consumidorIncluido);
    }

    public ConsumidorResponse buscarMedidor(Long medidor){

      return consumidorRepository.findByMedidor(medidor).map(this::converterParaResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Consumidor não encontrado com medidor: " + medidor));
    }

    public List<ConsumidorResponse> buscarTodos(){

        return consumidorRepository.findAll().stream().map(this::converterParaResponse).toList();
    }

    public ConsumidorResponse buscarUc(Long uc){

        Consumidor consumidor = obterEntidadePorUc(uc);

        return converterParaResponse(consumidor);
    }

    public List<Consumidor> buscarChaves(int chave){

        return consumidorRepository.findAllByChave(chave);
    }

    public List<Consumidor> buscarAlimentador(String alimentador){
        return consumidorRepository.findAllByAlimentador(alimentador);
    }

    @Transactional
    public ConsumidorResponse alterarCadastro(Long uc, Consumidor consumidor){
        Consumidor consumidorExistente = obterEntidadePorUc(uc);
        consumidorExistente.setNome(consumidor.getNome());
        consumidorExistente.setEndereco(consumidor.getEndereco());
        consumidorExistente.setMedidor(consumidor.getMedidor());
        consumidorExistente.setEmail(consumidor.getEmail());
        consumidorExistente.setTransformador(consumidor.getTransformador());
        consumidorExistente.setAlimentador(consumidor.getAlimentador());
        consumidorExistente.setChave(consumidor.getChave());
        consumidorExistente.setSituacao(consumidor.isSituacao());

        Consumidor consumidorAtualizado = consumidorRepository.save(consumidorExistente);
        return converterParaResponse(consumidorAtualizado);
    }

    private ConsumidorResponse converterParaResponse(Consumidor consumidor){
        return new ConsumidorResponse(
                consumidor.getUc(),
                consumidor.getNome(),
                consumidor.getEmail(),
                consumidor.getEndereco(),
                consumidor.getMedidor(),
                consumidor.getTransformador(),
                consumidor.getChave(),
                consumidor.getAlimentador(),
                consumidor.isSituacao()
        );
    }

    private Consumidor obterEntidadePorUc(Long uc){
        return consumidorRepository.findById(uc).orElseThrow(() ->
                new ConsumidorNaoEncontradoException(uc));
    }
}
