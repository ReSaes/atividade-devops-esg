package com.incdivcorp.esgincdivcorp.repository;

import com.incdivcorp.esgincdivcorp.model.MonitoramentoDiversidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoDiversidadeRepository extends JpaRepository<MonitoramentoDiversidade, Long> {
}