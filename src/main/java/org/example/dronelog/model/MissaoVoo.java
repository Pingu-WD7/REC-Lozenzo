package org.example.dronelog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class MissaoVoo {

    //TODO: garantir integridade de PK para os registros da entidade.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMissao;

    private String titulo;

    private String localOperacao;

    private LocalDate dataPrevista;

    private Double areaMapeadaKm2;

    @Enumerated(EnumType.STRING)
    private StatusMissao status;

    // TODO: relacionar corretamente com o responsável pela operação.
   @ManyToOne
   @JoinColumn(name = "id_piloto")
   private Piloto piloto;

    // TODO: relacionar corretamente com o equipamento/drone utilizado.
    @ManyToOne
    @JoinColumn(name = "id_drone")
    private Drone drone;

    public MissaoVoo() {
    }

    // TODO: completar os métodos de acesso necessários para uso nas camadas da API.
}
