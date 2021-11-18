package com.robinfood.feedback.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EncuestaResponse {

  private EncuestaModel encuesta;
  private List<PreguntaModel> preguntas;
}
