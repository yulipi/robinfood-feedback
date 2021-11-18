package com.robinfood.feedback.service;

import com.robinfood.feedback.model.EncuestaResponse;
import com.robinfood.feedback.model.GenericResponse;
import com.robinfood.feedback.model.RespuestaModel;
import com.robinfood.feedback.model.RespuestaRequest;

public interface IEncuestaService {
  EncuestaResponse consultarEncuesta(int id);

  GenericResponse guardar(RespuestaRequest respuesta);
}
