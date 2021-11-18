package com.robinfood.feedback.entity;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "opcion_pregunta")
public class OpcionPreguntaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  private String descripcion;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_pregunta")
  private PreguntaEntity pregunta;

  @OneToMany(mappedBy = "opcion", fetch = FetchType.EAGER)
  private Set<RespPreguntaEntity> respuestasPreguntas;

  public OpcionPreguntaEntity() {}
}
