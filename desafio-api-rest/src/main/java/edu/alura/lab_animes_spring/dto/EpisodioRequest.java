package edu.alura.lab_animes_spring.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;

public record EpisodioRequest(
                String titulo,
                @JsonAlias("data_lancamento") LocalDate dataLancamento,
                Integer temporada) {
}
