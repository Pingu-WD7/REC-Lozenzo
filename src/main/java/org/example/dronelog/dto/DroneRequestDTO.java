package org.example.dronelog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DroneRequestDTO(

        @NotBlank(message = "O identificador do drone é obrigatório.")
        String identificador,
        @NotBlank(message = "O modelo do drone é obrigatório.")
        String modelo,
        @NotNull(message = "A autonomia do drone é obrigatória.")
        @Positive(message = "A autonomia do drone deve ser um número positivo")
        Integer autonomiaMinutos,
        @NotNull(message = "A disponibilidade do drone é obrigatória.")
        Boolean disponivel
) {
}
