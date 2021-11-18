package com.robinfood.feedback.mapper;

import com.robinfood.feedback.entity.*;
import com.robinfood.feedback.model.RespuestaModel;
import com.robinfood.feedback.model.RespuestaRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class RespuestaRequestMapper
  implements IMapper<RespuestaRequest, RespuestaEntity> {

  @Override
  public RespuestaEntity map(RespuestaRequest respuestaRequest) {
    RespuestaEntity respuesta = new RespuestaEntity();
    respuesta.setUsuario(respuestaRequest.getUsuario());
    respuesta.setRespuestasPregunta(buildRespuestas(respuestaRequest.getRespuestas()));
    respuesta.setEncuesta(buildEncuesta(respuestaRequest));
    return respuesta;
  }

  private Set<RespPreguntaEntity> buildRespuestas(List<RespuestaModel> respuestas) {
    return respuestas.stream().map(this::buildRespuesta).collect(Collectors.toSet());
  }

  private RespPreguntaEntity buildRespuesta(RespuestaModel respuesta) {
    OpcionPreguntaEntity opcPregunta = new OpcionPreguntaEntity();
    opcPregunta.setId(respuesta.getIdOpcionPregunta());

    PreguntaEntity preg = new PreguntaEntity();
    preg.setId(respuesta.getIdPregunta());

    RespPreguntaEntity rtaPregunta = new RespPreguntaEntity();
    rtaPregunta.setDescripcion(respuesta.getDescripcion());
    rtaPregunta.setRespuesta(new RespuestaEntity());
    rtaPregunta.setPregunta(preg);
    rtaPregunta.setOpcion(opcPregunta);
    return rtaPregunta;
  }

  private EncuestaEntity buildEncuesta(RespuestaRequest respuestaRequest) {
    EncuestaEntity encuesta = new EncuestaEntity();
    encuesta.setId(respuestaRequest.getIdEncuesta());
    return encuesta;
  }
}
