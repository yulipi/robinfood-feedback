package com.robinfood.feedback.repository;

import com.robinfood.feedback.entity.RespPreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespPreguntaRepository
  extends JpaRepository<RespPreguntaEntity, Integer> {}
