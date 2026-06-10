package org.example.dronelog.repository;

import org.example.dronelog.model.MissaoVoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissaoVooRepository extends JpaRepository<MissaoVoo, Long> {

    List <MissaoVoo> findByStatus(String status);
    List <MissaoVoo> findByDataPrevista(String dataInicio, String dataFim);
    List <MissaoVoo> findByLocalOperacao(String localOperacao);
    List <MissaoVoo> findByTituloContainingIgnoreCase(String titulo);
    // TODO: definir as consultas necessárias para acompanhamento das missões.
}
