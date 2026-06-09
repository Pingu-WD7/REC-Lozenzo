package org.example.dronelog.controller;

import org.example.dronelog.dto.PilotoRequestDTO;
import org.example.dronelog.dto.PilotoResponseDTO;
import org.example.dronelog.service.PilotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    private final PilotoService pilotoService;

    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @GetMapping
    public List<PilotoResponseDTO> listar(@RequestParam(required = false) String nome) {
        // TODO: adaptar a listagem para aceitar uma consulta simples.
        return pilotoService.listar(nome);
    }

    @PutMapping("/{id}")
    public PilotoResponseDTO atualizar(@PathVariable Long id, @RequestBody PilotoRequestDTO dto) {
        // TODO: finalizar o fluxo de atualização.
        return pilotoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // TODO: encaminhar a remoção para a camada adequada.
        return ResponseEntity.noContent().build();
    }
}
