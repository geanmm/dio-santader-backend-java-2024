package edu.alura.lab_animes_spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alura.lab_animes_spring.model.Anime;
import edu.alura.lab_animes_spring.model.Categoria;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

  Boolean existsByTitulo(String titulo);

  List<Anime> findByCategorias(Categoria categoria);

  Optional<Anime> findByTituloIgnoreCase(String titulo);

  List<Anime> findByTituloContainingIgnoreCase(String titulo);

}
