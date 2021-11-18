package com.robinfood.feedback.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespuestaModel {

  private int idPregunta;
  private int idOpcionPregunta;
  private String descripcion;
}
