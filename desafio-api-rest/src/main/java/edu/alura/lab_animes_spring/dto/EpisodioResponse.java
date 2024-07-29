package edu.alura.lab_animes_spring.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import edu.alura.lab_animes_spring.model.Episodio;

public record EpisodioResponse(
    Long id,
    String titulo,
    @JsonAlias("data_lancamento") LocalDate dataLancamento,
    Integer temporada,
    @JsonAlias("anime_id") Long animeId) {

  public EpisodioResponse(Episodio ep) {
    this(ep.getId(), ep.getTitulo(), ep.getDataLancamento(), ep.getTemporada(), ep.getAnime().getId());
  }
}
