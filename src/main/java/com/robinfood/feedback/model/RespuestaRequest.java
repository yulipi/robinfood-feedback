package com.robinfood.feedback.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaRequest {

  private int idEncuesta;
  private String usuario;
  private List<RespuestaModel> respuestas;
}
