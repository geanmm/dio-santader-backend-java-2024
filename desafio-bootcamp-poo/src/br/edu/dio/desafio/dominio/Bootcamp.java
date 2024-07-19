package br.edu.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
  private String nome;
  private String descricao;
  private final LocalDate dataInicio;
  private final LocalDate dataFim;
  private Set<Conteudo> conteudos = new LinkedHashSet<>();
  private Set<Dev> devsInscritos = new LinkedHashSet<>();

  public Bootcamp(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataInicio = LocalDate.now();
    this.dataFim = dataInicio.plusDays(45);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public Set<Conteudo> getConteudos() {
    return conteudos;
  }

  public void setConteudos(Set<Conteudo> conteudos) {
    this.conteudos = conteudos;
  }

  public Set<Dev> getDevsInscritos() {
    return devsInscritos;
  }

  public void setDevsInscritos(Set<Dev> devsInscritos) {
    this.devsInscritos = devsInscritos;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, descricao, dataInicio, dataFim, conteudos, devsInscritos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Bootcamp bootcamp = (Bootcamp) obj;
    return Objects.equals(nome, bootcamp.nome)
        && Objects.equals(descricao, bootcamp.descricao)
        && Objects.equals(dataInicio, bootcamp.dataInicio)
        && Objects.equals(dataFim, bootcamp.dataFim)
        && Objects.equals(conteudos, bootcamp.conteudos)
        && Objects.equals(devsInscritos, bootcamp.devsInscritos);
  }

}
