package org.example.dronelog.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.dronelog.model.StatusMissao;

import java.time.LocalDate;

public record MissaoVooRequestDTO(
        //TODO: pedir atributos para criar registro.

        @NotBlank(message = "A missao precisa de um titulo")
        String titulo,

        @NotBlank(message = "A missao precisa de um local")
        String localOperacao,

        @NotNull(message = " O campo da data prevista deve ser preenchido")
        @FutureOrPresent(message = "A data prevista deve ser hoje ou nao ")
        LocalDate dataPrevista,

        @NotNull(message = " A area deve ser informada")
        Double areaMapeadaKm2,

        StatusMissao status,

        Long pilotoId,

        @NotBlank(message = "A missao precisa do nome do piloto")
        String pilotoNome,

        Long droneId,

        @NotBlank(message = "A missao precisa de um drone de identificacao")
        String droneIdentificador
) {
}
