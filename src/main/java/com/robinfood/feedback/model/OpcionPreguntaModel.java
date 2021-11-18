package com.robinfood.feedback.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class OpcionPreguntaModel {

  private int id;
  private String descripcion;
}
