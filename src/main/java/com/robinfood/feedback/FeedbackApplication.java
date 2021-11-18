package com.robinfood.feedback;

import com.robinfood.feedback.entity.EncuestaEntity;
import com.robinfood.feedback.repository.EncuestaRepository;
import com.robinfood.feedback.repository.OpcionPreguntaRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FeedbackApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeedbackApplication.class, args);
  }
}
