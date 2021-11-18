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
@Table(name = "pregunta")
public class PreguntaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String tipoPregunta;
  private String descripcion;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "encuesta_pregunta",
    joinColumns = { @JoinColumn(name = "pregunta_id") },
    inverseJoinColumns = { @JoinColumn(name = "encuesta_id") }
  )
  Set<EncuestaEntity> encuestas;

  @OneToMany(mappedBy = "pregunta", fetch = FetchType.EAGER)
  private Set<OpcionPreguntaEntity> opciones;

  @OneToMany(mappedBy = "pregunta", fetch = FetchType.EAGER)
  Set<RespPreguntaEntity> respuestasPregunta;

  public PreguntaEntity() {}
}
