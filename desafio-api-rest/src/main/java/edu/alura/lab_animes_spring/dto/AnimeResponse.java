package edu.alura.lab_animes_spring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import edu.alura.lab_animes_spring.model.Anime;
import edu.alura.lab_animes_spring.model.Categoria;

public record AnimeResponse(
    Long id,
    String titulo,
    @JsonAlias("ano_lancamento") Integer anoLancamento,
    @JsonAlias("total_temporadas") Integer totalTemporadas,
    Double avaliacao,
    List<String> categorias,
    Integer totalEpisodios) {

  public AnimeResponse(Anime anime) {
    this(
        anime.getId(),
        anime.getTitulo(),
        anime.getAnoLancamento(),
        anime.getTotalTemporadas(),
        anime.getAvaliacao(),
        anime.getCategorias().stream().map(Categoria::toString).toList(),
        anime.getEpisodios().size());
  }

}
