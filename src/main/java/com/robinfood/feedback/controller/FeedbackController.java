package com.robinfood.feedback.controller;

import com.robinfood.feedback.model.EncuestaModel;
import com.robinfood.feedback.model.EncuestaResponse;
import com.robinfood.feedback.model.GenericResponse;
import com.robinfood.feedback.model.RespuestaRequest;
import com.robinfood.feedback.service.EncuestaService;
import com.robinfood.feedback.service.IEncuestaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
@AllArgsConstructor
public class FeedbackController {

  private final IEncuestaService encuestaService;

  @GetMapping("/{id}")
  EncuestaResponse findById(@PathVariable int id) {
    return this.encuestaService.consultarEncuesta(id);
  }

  @PostMapping("/")
  GenericResponse save(@RequestBody RespuestaRequest respuesta) {
    return this.encuestaService.guardar(respuesta);
  }
}
