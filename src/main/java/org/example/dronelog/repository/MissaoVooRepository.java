package org.example.dronelog.repository;

import org.example.dronelog.model.MissaoVoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoVooRepository extends JpaRepository<MissaoVoo, Long> {

    // TODO: definir as consultas necessárias para acompanhamento das missões.
}
