package org.example.dronelog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PilotoRequestDTO(



         @Email(message = "O email do piloto deve ser válido.")
         String email,

         @NotBlank(message = "O registro da ANAC do piloto é obrigatorio.")
         String registroAnac,

         @NotBlank(message = "O email do piloto é obrigatorio.")
         @Email(message = "O email do piloto deve ser válido.")
         String nome,

         @NotNull(message = "O campo 'ativo' é obrigatório.")
         Boolean ativo,

          Long idPiloto
        //TODO: colocar atributos que serão requisitados para registro.
) {
}
