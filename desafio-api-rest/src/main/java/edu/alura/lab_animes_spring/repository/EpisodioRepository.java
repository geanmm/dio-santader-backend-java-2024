package edu.alura.lab_animes_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.alura.lab_animes_spring.model.Episodio;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

  List<Episodio> findByAnimeId(Long animeId);

  Boolean existsByAnimeIdAndTitulo(Long animeId, String titulo);

  @Query("SELECT e FROM Episodio e ORDER BY e.dataLancamento DESC")
  List<Episodio> listarRecentes();

  // List<Episodio> findTop30OrderByDataLancamentoDesc();

}
