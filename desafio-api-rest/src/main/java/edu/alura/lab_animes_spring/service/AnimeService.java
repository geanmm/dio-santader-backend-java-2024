package edu.alura.lab_animes_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alura.lab_animes_spring.dto.AnimeRequest;
import edu.alura.lab_animes_spring.dto.AnimeResponse;
import edu.alura.lab_animes_spring.model.Anime;
import edu.alura.lab_animes_spring.model.Categoria;
import edu.alura.lab_animes_spring.repository.AnimeRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AnimeService {

  @Autowired
  private AnimeRepository repository;

  public List<AnimeResponse> buscarTodos() {
    return repository.findAll().stream().map(AnimeResponse::new).toList();
  }

  public AnimeResponse buscarPorId(Long id) {
    Anime anime = buscarAnimePorId(id);
    return new AnimeResponse(anime);
  }

  public List<AnimeResponse> buscarPorCategoria(String cat) {
    Categoria categoria = Categoria.fromString(cat);
    return repository.findByCategorias(categoria).stream().map(AnimeResponse::new).toList();
  }

  public List<AnimeResponse> buscarPorTitulo(String titulo) {
    return repository.findByTituloContainingIgnoreCase(titulo).stream().map(AnimeResponse::new).toList();
  }

  @Transactional
  public void adicionarNovo(AnimeRequest dados) {
    Boolean animeExists = repository.existsByTitulo(dados.titulo());
    if (animeExists) {
      throw new EntityExistsException("O anime de título '" + dados.titulo() + "' já existe.");
    }
    Anime anime = new Anime(dados);
    repository.save(anime);
  }

  @Transactional
  public void atualizarAnime(Long id, AnimeRequest dados) {
    Anime anime = buscarAnimePorId(id);
    Optional<Anime> animeTituloExiste = repository.findByTituloIgnoreCase(dados.titulo());

    if (animeTituloExiste.isPresent() && animeTituloExiste.get().getId() != id) {
      throw new EntityExistsException("O título '" + dados.titulo() + "' já existe um outro anime.");
    }

    anime.setTitulo(dados.titulo());
    anime.setAnoLancamento(dados.anoLancamento());
    anime.setTotalTemporadas(dados.totalTemporadas());
    anime.setAvaliacao(dados.avaliacao());
    anime.setCategorias(dados.categorias().stream().map(c -> Categoria.fromString(c)).toList());
  }

  @Transactional
  public void deletarAnime(Long id) {
    Anime anime = buscarAnimePorId(id);
    repository.delete(anime);
  }

  private Anime buscarAnimePorId(Long id) {
    Optional<Anime> anime = repository.findById(id);
    if (anime.isPresent()) {
      return anime.get();
    }
    throw new EntityNotFoundException("Anime de ID '" + id + "' não existe.");
  }

}
