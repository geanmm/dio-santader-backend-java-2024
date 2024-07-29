package edu.alura.lab_animes_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alura.lab_animes_spring.dto.AnimeRequest;
import edu.alura.lab_animes_spring.dto.AnimeResponse;
import edu.alura.lab_animes_spring.service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("animes")
public class AnimeController {

  @Autowired
  private AnimeService service;

  @GetMapping
  @Operation(summary = "Lista todos os animes")
  public List<AnimeResponse> buscarTodos() {
    return service.buscarTodos();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Detalha o anime pelo ID")
  public AnimeResponse buscarPorId(@PathVariable Long id) {
    return service.buscarPorId(id);
  }

  @GetMapping("/categoria/{categoria}")
  @Operation(summary = "Lista todos os animes pela categoria")
  public List<AnimeResponse> buscarPorCategoria(@PathVariable String categoria) {
    return service.buscarPorCategoria(categoria);
  }

  @GetMapping("/titulo/{titulo}")
  @Operation(summary = "Lista todos os animes por parte do nome")
  public List<AnimeResponse> buscarPorTitulo(@PathVariable String titulo) {
    return service.buscarPorTitulo(titulo);
  }

  @PostMapping
  @Operation(summary = "Adiciona um novo anime")
  public String adicionarAnime(@RequestBody AnimeRequest dados) {
    service.adicionarNovo(dados);
    return "O anime '" + dados.titulo() + "' foi adicionado com sucesso!";
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualiza o anime pelo id")
  public String atualizarAnime(@PathVariable Long id, @RequestBody AnimeRequest dados) {
    service.atualizarAnime(id, dados);
    return "O anime '" + dados.titulo() + "' foi atualizado com sucesso.";
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Remove o anime pelo id")
  public String deletarAnime(@PathVariable Long id) {
    service.deletarAnime(id);
    return "O anime foi removido com sucesso.";
  }

}
