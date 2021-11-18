package com.robinfood.feedback;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.robinfood.feedback.entity.EncuestaEntity;
import com.robinfood.feedback.entity.RespuestaEntity;
import com.robinfood.feedback.mapper.EncuestaResponseMapper;
import com.robinfood.feedback.mapper.IMapper;
import com.robinfood.feedback.mapper.RespuestaRequestMapper;
import com.robinfood.feedback.model.EncuestaResponse;
import com.robinfood.feedback.model.GenericResponse;
import com.robinfood.feedback.model.RespuestaRequest;
import com.robinfood.feedback.repository.EncuestaRepository;
import com.robinfood.feedback.repository.RespPreguntaRepository;
import com.robinfood.feedback.repository.RespuestaRepository;
import com.robinfood.feedback.service.EncuestaService;
import com.robinfood.feedback.service.IEncuestaService;
import java.util.Optional;
import java.util.Set;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class EncuestaServiceTest {

  @MockBean
  private EncuestaRepository encuestaRepository;

  @MockBean
  private RespuestaRepository respuestaRepository;

  @MockBean
  private RespPreguntaRepository respPreguntaRepository;

  private final IMapper<EncuestaEntity, EncuestaResponse> encuestaModelMapper = new EncuestaResponseMapper();
  private final IMapper<RespuestaRequest, RespuestaEntity> respuestaRequestMapper = new RespuestaRequestMapper();

  @Autowired
  private IEncuestaService encuestaService;

  @BeforeEach
  public void init() {
    this.encuestaService =
      new EncuestaService(
        encuestaRepository,
        respuestaRepository,
        respPreguntaRepository,
        encuestaModelMapper,
        respuestaRequestMapper
      );
    Mockito
      .when(encuestaRepository.findById(1))
      .thenReturn(Optional.of(TestUtil.getEncuestaEntity()));
    Mockito
      .when(respuestaRepository.save(ArgumentMatchers.any()))
      .thenReturn(TestUtil.getRespuestaEntity());
    Mockito
      .when(respPreguntaRepository.save(ArgumentMatchers.any()))
      .thenReturn(TestUtil.getRespPreguntaEntity());
  }

  @Test
  void getPreguntas() {
    EncuestaResponse res = this.encuestaService.consultarEncuesta(1);
    Assertions.assertEquals(
      TestUtil.getEncuestaEntity().getNombreEncuesta(),
      res.getEncuesta().getNombreEncuesta()
    );
    Assertions.assertEquals(TestUtil.getEncuestaEntity().getPreguntas().size(), 1);
  }

  @Test
  void saveRespuesta() throws JsonProcessingException {
    Mockito
      .when(respuestaRepository.save(ArgumentMatchers.any()))
      .thenReturn(TestUtil.getRespuestaEntity());
    GenericResponse res = this.encuestaService.guardar(TestUtil.getRespuestaModel());
    Assertions.assertEquals("Se registro la encuesta", res.getMessage());
  }

  @Test
  void saveRespuestaFail() throws JsonProcessingException {
    Mockito
      .when(respuestaRepository.save(ArgumentMatchers.any()))
      .thenThrow(new ArrayIndexOutOfBoundsException());
    GenericResponse res = this.encuestaService.guardar(TestUtil.getRespuestaModel());
    Assertions.assertEquals("Se presento un error", res.getMessage());
  }
}
