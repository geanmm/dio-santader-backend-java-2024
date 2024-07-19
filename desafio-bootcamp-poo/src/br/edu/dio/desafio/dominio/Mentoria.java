package br.edu.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
  private LocalDate data;

  public Mentoria(String titulo, String descricao) {
    this.setTitulo(titulo);
    this.setDescricao(descricao);
    this.data = LocalDate.now();
  }

  @Override
  public double calcularXp() {
    return XP_PADRAO + 20d;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return Color.CYAN + "\n[Mentoria]" + Color.RESET +
        Color.YELLOW + " Título: " + Color.RESET + this.getTitulo() +
        Color.YELLOW + " Descrição: " + Color.RESET + this.getDescricao() +
        Color.YELLOW + " Data: " + Color.RESET + this.getData();
  }

}
