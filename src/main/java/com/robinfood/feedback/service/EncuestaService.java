package com.robinfood.feedback.service;

import com.robinfood.feedback.entity.EncuestaEntity;
import com.robinfood.feedback.entity.RespuestaEntity;
import com.robinfood.feedback.mapper.IMapper;
import com.robinfood.feedback.model.EncuestaResponse;
import com.robinfood.feedback.model.GenericResponse;
import com.robinfood.feedback.model.RespuestaRequest;
import com.robinfood.feedback.repository.EncuestaRepository;
import com.robinfood.feedback.repository.RespPreguntaRepository;
import com.robinfood.feedback.repository.RespuestaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EncuestaService implements IEncuestaService {

  private final EncuestaRepository encuestaRepository;
  private final RespuestaRepository respuestaRepository;
  private final RespPreguntaRepository respPreguntaRepository;
  private final IMapper<EncuestaEntity, EncuestaResponse> encuestaModelMapper;
  private final IMapper<RespuestaRequest, RespuestaEntity> respuestaRequestMapper;

  @Override
  public EncuestaResponse consultarEncuesta(int id) {
    return this.encuestaModelMapper.map(
        this.encuestaRepository.findById(id).orElse(null)
      );
  }

  @Override
  public GenericResponse guardar(RespuestaRequest respuesta) {
    try {
      RespuestaEntity respuestaMapped = respuestaRequestMapper.map(respuesta);
      RespuestaEntity respuestaSaved = this.respuestaRepository.save(respuestaMapped);
      respuestaMapped
        .getRespuestasPregunta()
        .forEach(i -> {
          i.getRespuesta().setId(respuestaSaved.getId());
          this.respPreguntaRepository.save(i);
        });
      return GenericResponse.builder().message("Se registro la encuesta").build();
    } catch (Exception e) {
      e.printStackTrace();
      return GenericResponse.builder().message("Se presento un error").build();
    }
  }
}
