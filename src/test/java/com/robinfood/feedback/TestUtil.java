package com.robinfood.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.feedback.entity.*;
import com.robinfood.feedback.model.RespuestaRequest;
import java.util.Set;

public class TestUtil {

  public static EncuestaEntity getEncuestaEntity() {
    EncuestaEntity encuestaEntity = new EncuestaEntity();
    encuestaEntity.setNombreEncuesta("Satisfaccion");
    encuestaEntity.setId(1);
    PreguntaEntity preguntaEntity = new PreguntaEntity();
    preguntaEntity.setDescripcion("Primer pregunta");
    preguntaEntity.setTipoPregunta("C");

    OpcionPreguntaEntity opcionPreguntaEntity = new OpcionPreguntaEntity();
    opcionPreguntaEntity.setId(1);
    opcionPreguntaEntity.setDescripcion("Si");
    opcionPreguntaEntity.setDescripcion("No");
    preguntaEntity.setOpciones(Set.of(opcionPreguntaEntity));
    encuestaEntity.setPreguntas(Set.of(preguntaEntity));
    return encuestaEntity;
  }

  public static RespPreguntaEntity getRespPreguntaEntity() {
    return new RespPreguntaEntity();
  }

  public static RespuestaEntity getRespuestaEntity() {
    RespuestaEntity resp = new RespuestaEntity();
    resp.setId(1L);
    return resp;
  }

  public static RespuestaRequest getRespuestaModel() throws JsonProcessingException {
    String json =
      "{\n" +
      "\t\"idEncuesta\":1,\n" +
      "\t\"usuario\": \"dago\",\n" +
      "\t \"respuestas\": [\n" +
      "\t\t{\n" +
      "\t\t\t\"idPregunta\":1,\n" +
      "\t\t\t\"idOpcionPregunta\":3,\n" +
      "\t\t\t\"descripcion\":null\n" +
      "\t\t},\n" +
      "\t\t{\n" +
      "\t\t\t\"idPregunta\":2,\n" +
      "\t\t\t\"idOpcionPregunta\":null,\n" +
      "\t\t\t\"descripcion\":\"Me gusto mucho, asi esta bien\"\n" +
      "\t\t},\n" +
      "\t\t {\n" +
      "\t\t\t\"idPregunta\":3,\n" +
      "\t\t\t\"idOpcionPregunta\":3,\n" +
      "\t\t\t\"descripcion\":null\n" +
      "\t\t}\n" +
      "\t \n" +
      "\t]\n" +
      "}";
    ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.readValue(json, RespuestaRequest.class);
  }
}
