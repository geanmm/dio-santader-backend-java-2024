package br.edu.dio.desafio.dominio;

public class Curso extends Conteudo {
  private int cargahoraria;

  public Curso(String titulo, String descricao, int cargahoraria) {
    this.setTitulo(titulo);
    this.setDescricao(descricao);
    this.cargahoraria = cargahoraria;

  }

  @Override
  public double calcularXp() {
    return XP_PADRAO * cargahoraria;
  }

  public int getCargahoraria() {
    return cargahoraria;
  }

  public void setCargahoraria(int cargahoraria) {
    this.cargahoraria = cargahoraria;
  }

  @Override
  public String toString() {
    return Color.CYAN + "\n[Curso]" + Color.RESET +
        Color.YELLOW + " Título: " + Color.RESET + this.getTitulo() +
        Color.YELLOW + " Descrição: " + Color.RESET + this.getDescricao() +
        Color.YELLOW + " Carga horária: " + Color.RESET + this.getCargahoraria() + "h";
  }

}
