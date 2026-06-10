package org.example.dronelog.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.example.dronelog.dto.MissaoVooRequestDTO;
import org.example.dronelog.dto.MissaoVooResponseDTO;
import org.example.dronelog.model.StatusMissao;
import org.example.dronelog.service.MissaoVooService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoVooController {

    private final MissaoVooService missaoVooService;
    private final DroneController droneController;
    private final PilotoController pilotoController;

    public MissaoVooController(MissaoVooService missaoVooService, DroneController droneController, PilotoController pilotoController) {
        this.missaoVooService = missaoVooService;
        this.droneController = droneController;
        this.pilotoController = pilotoController;
    }

    @Operation(summary = "Lista as missoes de voo com filtros opcionais")
    @GetMapping
    public List<MissaoVooResponseDTO> listar(
            @RequestParam(required = false) StatusMissao status,
            @RequestParam(required = false) String localOperacao,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrevista
    ) {
        // TODO: ligar a rota à lógica de consulta das missões.
        return missaoVooService.listar(status, localOperacao, dataPrevista);

    }

    @Operation(summary = "Busca uma missao de voo por ID")
    @GetMapping("/{id}")
    public MissaoVooResponseDTO buscarPorId(@PathVariable Long id) {
        // TODO: buscar uma missão específica.

        return missaoVooService.buscarPorId(id);
    }

    @Operation(summary = "Registra uma nova missao de voo")
    @PostMapping
    public MissaoVooResponseDTO cadastrar(@RequestBody @Valid MissaoVooRequestDTO dto) {
        // TODO: registrar a missão considerando os vínculos necessários.
        return missaoVooService.cadastrar(dto);
    }

    @Operation(summary = "Atualiza uma missao de voo existente")
    @PutMapping("/{id}")
    public MissaoVooResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid MissaoVooRequestDTO dto) {
        // TODO: atualizar uma missão já cadastrada.
        if (dto.status() == StatusMissao.CONCLUIDA) {
            return missaoVooService.atualizar(id, dto);
        }
        return null;
    }
    @Operation(summary = "Remove uma missao de voo do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // TODO: remover uma missão quando for permitido.
        missaoVooService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
