package com.robinfood.feedback.entity;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "encuesta")
public class EncuestaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombreEncuesta;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "encuesta_pregunta",
    joinColumns = { @JoinColumn(name = "encuesta_id") },
    inverseJoinColumns = { @JoinColumn(name = "pregunta_id") }
  )
  Set<PreguntaEntity> preguntas;

  @OneToMany(mappedBy = "encuesta", fetch = FetchType.EAGER)
  private Set<RespuestaEntity> respuestas;

  public EncuestaEntity() {}
}
