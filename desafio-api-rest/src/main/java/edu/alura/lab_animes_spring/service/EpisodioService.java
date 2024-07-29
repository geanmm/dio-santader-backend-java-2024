package edu.alura.lab_animes_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alura.lab_animes_spring.dto.EpisodioRequest;
import edu.alura.lab_animes_spring.dto.EpisodioResponse;
import edu.alura.lab_animes_spring.model.Anime;
import edu.alura.lab_animes_spring.model.Episodio;
import edu.alura.lab_animes_spring.repository.*;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EpisodioService {

  @Autowired
  private EpisodioRepository episodioRepository;

  @Autowired
  private AnimeRepository animeRepository;

  public List<EpisodioResponse> buscarRecentes() {
    return episodioRepository.listarRecentes().stream().map(EpisodioResponse::new).toList();
  }

  public List<EpisodioResponse> buscarTodos(Long animeId) {
    return episodioRepository.findByAnimeId(animeId).stream().map(EpisodioResponse::new).toList();

  }

  public void adicionarNovo(Long animeId, EpisodioRequest dados) {
    Boolean episodioExiste = existeEPComMesmoTituloNoAnime(animeId, dados.titulo());
    Anime anime = buscarAnimePorId(animeId);

    if (episodioExiste) {
      throw new EntityExistsException(
          "O episódio de título '" + dados.titulo() + "' já existe para o anime '" + anime.getTitulo() + "'.");
    }
    Episodio episodio = new Episodio(dados);
    episodio.setAnime(anime);

    episodioRepository.save(episodio);
  }

  @Transactional
  public void atualizarEpisodio(Long id, EpisodioRequest dados) {
    Episodio episodio = buscarEpisodioPorId(id);
    Anime anime = buscarAnimePorId(episodio.getAnime().getId());

    // Verificar se já existe um episódio com esse nome nesse mesmo anime;
    Boolean episodioExiste = existeEPComMesmoTituloNoAnime(anime.getId(), dados.titulo());
    // Se já existe um episódio com esse título e NÃO é o que tá sendo alterado;
    if (episodioExiste && episodio.getId() != id) {
      throw new EntityExistsException(
          "O episódio de título '" + dados.titulo() + "' já existe para o anime '" + anime.getTitulo() + "'.");
    }
    episodio.setTitulo(dados.titulo());
    episodio.setDataLancamento(dados.dataLancamento());
    episodio.setTemporada(dados.temporada());
  }

  @Transactional
  public void deletarEpisodio(Long id) {
    Episodio episodio = buscarEpisodioPorId(id);
    episodioRepository.delete(episodio);
  }

  //
  private Episodio buscarEpisodioPorId(Long id) {
    Optional<Episodio> episodio = episodioRepository.findById(id);

    if (episodio.isPresent()) {
      return episodio.get();
    }
    throw new EntityNotFoundException("Episódio de ID '" + id + "' não existe.");
  }

  private Anime buscarAnimePorId(Long id) {
    Optional<Anime> anime = animeRepository.findById(id);
    if (anime.isPresent()) {
      return anime.get();
    }
    throw new EntityNotFoundException("Anime de ID '" + id + "' não existe.");
  }

  private Boolean existeEPComMesmoTituloNoAnime(Long animeId, String titulo) {
    return episodioRepository.existsByAnimeIdAndTitulo(animeId, titulo);
  }

}
