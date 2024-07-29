package edu.alura.lab_animes_spring.model;

import java.time.LocalDate;

import edu.alura.lab_animes_spring.dto.EpisodioRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "episodios")
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titulo;

  @Column(name = "data_lancamento", nullable = false)
  private LocalDate dataLancamento;

  @Column(nullable = false)
  private Integer temporada;

  @ManyToOne
  private Anime anime;

  public Episodio() {
  }

  public Episodio(EpisodioRequest dados) {
    this.titulo = dados.titulo();
    this.dataLancamento = dados.dataLancamento();
    this.temporada = dados.temporada();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public LocalDate getDataLancamento() {
    return dataLancamento;
  }

  public void setDataLancamento(LocalDate dataLancamento) {
    this.dataLancamento = dataLancamento;
  }

  public Integer getTemporada() {
    return temporada;
  }

  public void setTemporada(Integer temporada) {
    this.temporada = temporada;
  }

  public Anime getAnime() {
    return anime;
  }

  public void setAnime(Anime anime) {
    this.anime = anime;
  }

}
