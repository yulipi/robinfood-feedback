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
@Table(name = "respuesta")
public class RespuestaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String usuario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_encuesta")
  private EncuestaEntity encuesta;

  @OneToMany(mappedBy = "respuesta", fetch = FetchType.EAGER)
  Set<RespPreguntaEntity> respuestasPregunta;

  public RespuestaEntity() {}
}
