package edu.alura.lab_animes_spring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AnimeRequest(
    String titulo,
    @JsonAlias("ano_lancamento") Integer anoLancamento,
    @JsonAlias("total_temporadas") Integer totalTemporadas,
    Double avaliacao,
    List<String> categorias) {
}
