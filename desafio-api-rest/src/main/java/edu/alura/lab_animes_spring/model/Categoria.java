package edu.alura.lab_animes_spring.model;

public enum Categoria {
  ACAO("Ação"),
  ARTES_MARCIAIS("Artes Marciais"),
  AVENTURA("Aventura"),
  COMEDIA("Comédia"),
  DRAMA("Drama"),
  ESPORTE("Esporte"),
  FANTASIA("Fantasia"),
  FICCAO_CIENTÍFICA("Ficção científica"),
  HISTORICO("Histórico"),
  HORROR("Horror"),
  LIGHT_NOVEL("Light Novel"),
  MAGIA("Magia"),
  MECHA("Mecha"),
  MILITAR("Militar"),
  MISTERIO("Mistério"),
  MUSICAL("Musical"),
  ROMANCE("Romance"),
  SAMURAI("Samurai"),
  SEINEN("Seinen"),
  SHOUJO("Shoujo"),
  SHOUNEN("Shounen"),
  SLICE_OF_LIFE("Slice Of Life"),
  SOBRENATURAL("Sobrenatural"),
  SUSPENSE("Suspense"),
  TERROR("Terror");

  private final String categoria;

  private Categoria(String categoria) {
    this.categoria = categoria;
  }

  public static Categoria fromString(String str) {
    for (Categoria cat : Categoria.values()) {
      if (cat.categoria.equalsIgnoreCase(str))
        return cat;
    }
    throw new IllegalArgumentException("Nenhuma categoria encontrada para " + str);
  }

  @Override
  public String toString() {
    return this.categoria;
  }
}
