package com.robinfood.feedback.repository;

import com.robinfood.feedback.entity.OpcionPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionPreguntaRepository
  extends JpaRepository<OpcionPreguntaEntity, Integer> {}
