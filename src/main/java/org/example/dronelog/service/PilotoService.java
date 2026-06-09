package org.example.dronelog.service;

import org.example.dronelog.dto.PilotoRequestDTO;
import org.example.dronelog.dto.PilotoResponseDTO;
import org.example.dronelog.model.Piloto;
import org.example.dronelog.repository.PilotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    //TODO: colocar construtor para chamar métodos.

    final PilotoRepository pilotoRepository;

    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    public List<PilotoResponseDTO> listar(String nome) {
        // TODO: usar o parâmetro recebido quando fizer sentido.
        return pilotoRepository.findAll().stream().map(this::toResponse).toList();
    }

    public PilotoResponseDTO buscarPorId(Long id) {
        Piloto piloto = buscarPiloto(id);
        return toResponse(piloto);
    }

    public PilotoResponseDTO cadastrar(PilotoRequestDTO dto) {
        Piloto piloto = new Piloto();

        piloto.setNome(dto.nome());
        piloto.setRegistroAnac(dto.registroAnac());
        piloto.setEmail(dto.email());
        piloto.setAtivo(true);

        // TODO: transportar os dados recebidos para a entidade.

        return toResponse(pilotoRepository.save(piloto));
    }

    public PilotoResponseDTO atualizar(Long id, PilotoRequestDTO dto) {
        Piloto piloto = buscarPiloto(id);

        piloto.setNome(dto.nome());
        piloto.setRegistroAnac(dto.registroAnac());
        piloto.setEmail(dto.email());
        piloto.setAtivo(true);

        // TODO: atualizar os campos corretos sem criar outro registro.

        return toResponse(pilotoRepository.save(piloto));
    }

    public void deletar(Long id) {
        Piloto piloto = buscarPiloto(id);
        // TODO: decidir como tratar pilotos com missões vinculadas.

        pilotoRepository.delete(piloto);

    }

    public Piloto buscarPiloto(Long id) {
        //TODO: fazer o return.
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Piloto não encontrado."));
    }

    private PilotoResponseDTO toResponse(Piloto piloto) {
        // TODO: montar o DTO de saída com os dados necessários.
        return new PilotoResponseDTO(
                piloto.getIdPiloto(),
                piloto.getEmail(),
                piloto.getNome(),
                piloto.getRegistroAnac(),
                piloto.getAtivo()
        );
    }
}
