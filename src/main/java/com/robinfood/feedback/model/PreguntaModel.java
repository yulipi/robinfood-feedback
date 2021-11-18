package com.robinfood.feedback.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PreguntaModel {

  private int id;
  private String tipoPregunta;
  private String descripcion;
  private List<OpcionPreguntaModel> opciones;
}
