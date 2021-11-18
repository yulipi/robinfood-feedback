package com.robinfood.feedback.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EncuestaModel {

  private int id;
  private String nombreEncuesta;
}
