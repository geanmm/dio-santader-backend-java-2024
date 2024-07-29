package edu.alura.lab_animes_spring.model;

import java.util.ArrayList;
import java.util.List;

import edu.alura.lab_animes_spring.dto.AnimeRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "animes")
public class Anime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titulo;
  @Column(name = "ano_lancamento", nullable = false)
  private Integer anoLancamento;
  @Column(name = "total_temporadas", nullable = false)
  private Integer totalTemporadas;
  private Double avaliacao;

  @ElementCollection
  @CollectionTable(name = "animes_categorias", joinColumns = @JoinColumn(name = "anime_id"))
  @Enumerated(EnumType.STRING)
  private List<Categoria> categorias = new ArrayList<>();

  @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Episodio> episodios = new ArrayList<>();

  public Anime() {
  }

  public Anime(AnimeRequest dados) {
    this.titulo = dados.titulo();
    this.anoLancamento = dados.anoLancamento();
    this.totalTemporadas = dados.totalTemporadas();
    this.avaliacao = dados.avaliacao();
    this.categorias = dados.categorias().stream().map(Categoria::fromString).toList();
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

  public Integer getAnoLancamento() {
    return anoLancamento;
  }

  public void setAnoLancamento(Integer anoLancamento) {
    this.anoLancamento = anoLancamento;
  }

  public Integer getTotalTemporadas() {
    return totalTemporadas;
  }

  public void setTotalTemporadas(Integer totalTemporadas) {
    this.totalTemporadas = totalTemporadas;
  }

  public Double getAvaliacao() {
    return avaliacao;
  }

  public void setAvaliacao(Double avaliacao) {
    this.avaliacao = avaliacao;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void setEpisodios(List<Episodio> episodios) {
    this.episodios = episodios;
  }

}
