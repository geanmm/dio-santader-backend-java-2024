package br.edu.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
  private String nome;
  private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

  public Dev(String nome) {
    this.nome = nome;
  }

  public void inscrever(Bootcamp bootcamp) {
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  public void progredir(Bootcamp bootcamp) {
    Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

    if (conteudo.isPresent()) {
      this.conteudosConcluidos.add(conteudo.get());
      this.conteudosInscritos.remove(conteudo.get());
    } else {
      System.err.println("Você não está matriculado em nenhum conteúdo!");
    }
  }

  public double calcularTotalExp() {
    return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Conteudo> getConteudosInscritos() {
    return conteudosInscritos;
  }

  public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
    this.conteudosInscritos = conteudosInscritos;
  }

  public Set<Conteudo> getConteudosConcluidos() {
    return conteudosConcluidos;
  }

  public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
    this.conteudosConcluidos = conteudosConcluidos;
  }

  public void imprimirInformacoes() {
    System.out.println("\n> Desenvolvedor " + this.getNome());
    System.out.println("\nConteúdos Inscritos: " + this.getConteudosInscritos());
    System.out.println("\nConteúdos Concluídos: " + this.getConteudosConcluidos());
    System.out.println("\nTotal de XP: " + this.calcularTotalExp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Dev dev = (Dev) obj;
    return Objects.equals(nome, dev.nome)
        && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
        && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
  }

}
