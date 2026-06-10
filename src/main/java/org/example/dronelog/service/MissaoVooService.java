package org.example.dronelog.service;

import org.example.dronelog.dto.MissaoVooRequestDTO;
import org.example.dronelog.dto.MissaoVooResponseDTO;
import org.example.dronelog.exception.RecursoNaoEncontradoException;
import org.example.dronelog.model.MissaoVoo;
import org.example.dronelog.model.StatusMissao;
import org.example.dronelog.repository.MissaoVooRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MissaoVooService {

    //TODO: completar ou alterar.
    private final MissaoVooRepository missaoVooRepository;
    private final PilotoService pilotoService;


    public MissaoVooService(MissaoVooRepository missaoVooRepository, PilotoService pilotoService) {
        this.missaoVooRepository = missaoVooRepository;
        this.pilotoService = pilotoService;

    }

    public List<MissaoVooResponseDTO> listar(StatusMissao status, String localOperacao, LocalDate dataPrevista) {
        // TODO: construir a listagem e os filtros necessários.
        return missaoVooRepository.findAll().stream().map(this::toResponse).toList();
    }

    public MissaoVooResponseDTO buscarPorId(Long id) {
        // TODO: localizar e converter a missão.
        return toResponse( buscarMissao (id));
    }

    public MissaoVooResponseDTO cadastrar(MissaoVooRequestDTO dto) {
        // TODO: montar a entidade, preencher dados simples e resolver vínculos.
            MissaoVoo missao = new MissaoVoo();
            missao.setTitulo(dto.titulo());
            missao.setLocalOperacao(dto.localOperacao());
            missao.setDataPrevista(dto.dataPrevista());
            missao.setAreaMapeadaKm2(dto.areaMapeadaKm2());
            missao.setStatus(StatusMissao.PENDENTE);
        return toResponse(missaoVooRepository.save(missao));
    }

    public MissaoVooResponseDTO atualizar(Long id, MissaoVooRequestDTO dto) {
        // TODO: recuperar o registro existente e aplicar alterações permitidas.
            MissaoVoo missao = buscarMissao(id);
            missao.setTitulo(dto.titulo());
            missao.setLocalOperacao(dto.localOperacao());
            missao.setDataPrevista(dto.dataPrevista());
            missao.setAreaMapeadaKm2(dto.areaMapeadaKm2());
        return toResponse(missaoVooRepository.save(missao));
    }

    public void deletar(Long id) {
        // TODO: remover o registro correto.
            MissaoVoo missao = buscarMissao(id);
            missaoVooRepository.delete(missao);
    }

    private MissaoVoo buscarMissao(Long id) {
        return missaoVooRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Missão de voo não encontrada."));
    }

    private MissaoVooResponseDTO toResponse(MissaoVoo missao) {
        // TODO: transformar a entidade em resposta sem expor objetos inteiros.

        return new MissaoVooResponseDTO(
             missao.getIdMissao(),
             missao.getTitulo(),
             missao.getLocalOperacao(),
             missao.getDataPrevista(),
             missao.getAreaMapeadaKm2(),
             missao.getStatus()
        );
    }
}
