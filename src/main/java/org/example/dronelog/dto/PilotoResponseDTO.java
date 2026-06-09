package org.example.dronelog.dto;

public record PilotoResponseDTO(
        //TODO: colocar atributos de resposta.

         Long idPiloto,
         String nome,
         String registroAnac,
         String email,
         Boolean ativo
) {
}
