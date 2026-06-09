package org.example.dronelog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PilotoRequestDTO(


         @NotBlank(message = "O nome do piloto é obrigatório.")
         String email,

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
