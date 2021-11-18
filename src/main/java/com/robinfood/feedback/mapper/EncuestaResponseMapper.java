package com.robinfood.feedback.mapper;

import com.robinfood.feedback.entity.EncuestaEntity;
import com.robinfood.feedback.entity.OpcionPreguntaEntity;
import com.robinfood.feedback.entity.PreguntaEntity;
import com.robinfood.feedback.model.EncuestaModel;
import com.robinfood.feedback.model.EncuestaResponse;
import com.robinfood.feedback.model.OpcionPreguntaModel;
import com.robinfood.feedback.model.PreguntaModel;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EncuestaResponseMapper implements IMapper<EncuestaEntity, EncuestaResponse> {

  @Override
  public EncuestaResponse map(EncuestaEntity encuesta) {
    return EncuestaResponse
      .builder()
      .encuesta(buildEncuesta(encuesta))
      .preguntas(buildPreguntas(encuesta))
      .build();
  }

  private EncuestaModel buildEncuesta(EncuestaEntity encuesta) {
    return EncuestaModel
      .builder()
      .id(encuesta.getId())
      .nombreEncuesta(encuesta.getNombreEncuesta())
      .build();
  }

  private List<PreguntaModel> buildPreguntas(EncuestaEntity encuesta) {
    return encuesta
      .getPreguntas()
      .stream()
      .map(this::buildPregunta)
      .collect(Collectors.toList());
  }

  private PreguntaModel buildPregunta(PreguntaEntity pregunta) {
    return PreguntaModel
      .builder()
      .descripcion(pregunta.getDescripcion())
      .tipoPregunta(pregunta.getTipoPregunta())
      .opciones(
        pregunta
          .getOpciones()
          .stream()
          .map(this::buildOpciones)
          .collect(Collectors.toList())
      )
      .build();
  }

  private OpcionPreguntaModel buildOpciones(OpcionPreguntaEntity opcion) {
    return OpcionPreguntaModel
      .builder()
      .descripcion(opcion.getDescripcion())
      .id(opcion.getId())
      .build();
  }
}
