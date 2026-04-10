package com.reparation.garage.repository;

import com.reparation.garage.model.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparationRepository extends JpaRepository<Reparation, Long> {
}
