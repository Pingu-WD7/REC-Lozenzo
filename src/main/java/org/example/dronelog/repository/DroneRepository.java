package org.example.dronelog.repository;

import org.example.dronelog.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Long> {

    // TODO: garantir que as consultas estão de acordo.
    List<Drone> findByDisponivel(Boolean disponivel);
}
