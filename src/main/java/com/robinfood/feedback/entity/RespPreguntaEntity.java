package com.robinfood.feedback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "resp_pregunta")
public class RespPreguntaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String descripcion;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_respuesta")
  private RespuestaEntity respuesta;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_pregunta")
  private PreguntaEntity pregunta;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_opcion")
  @JsonIgnore
  private OpcionPreguntaEntity opcion;

  public RespPreguntaEntity() {}
}
