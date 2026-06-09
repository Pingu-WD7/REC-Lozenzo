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
        return List.of();
    }

    public MissaoVooResponseDTO buscarPorId(Long id) {
        // TODO: localizar e converter a missão.
        return null;
    }

    public MissaoVooResponseDTO cadastrar(MissaoVooRequestDTO dto) {
        // TODO: montar a entidade, preencher dados simples e resolver vínculos.
        return null;
    }

    public MissaoVooResponseDTO atualizar(Long id, MissaoVooRequestDTO dto) {
        // TODO: recuperar o registro existente e aplicar alterações permitidas.
        return null;
    }

    public void deletar(Long id) {
        // TODO: remover o registro correto.
    }

    private MissaoVoo buscarMissao(Long id) {
        return missaoVooRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Missão de voo não encontrada."));
    }

    private MissaoVooResponseDTO toResponse(MissaoVoo missao) {
        // TODO: transformar a entidade em resposta sem expor objetos inteiros.
        return null;
    }
}
