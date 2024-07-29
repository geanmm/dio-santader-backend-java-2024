package edu.alura.lab_animes_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.alura.lab_animes_spring.dto.EpisodioRequest;
import edu.alura.lab_animes_spring.dto.EpisodioResponse;
import edu.alura.lab_animes_spring.service.EpisodioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/animes")
public class EpisodioController {

  @Autowired
  private EpisodioService service;

  @GetMapping("/latest")
  @Operation(summary = "Lista todos os animes pela data mais recente")
  public List<EpisodioResponse> listarEpisodiosRecentes() {
    return service.buscarRecentes();
  }

  @GetMapping("/{idAnime}/episodios")
  @Operation(summary = "Lista todos os episódios pelo id do anime")
  public List<EpisodioResponse> listarTodosPorAnime(@PathVariable Long idAnime) {
    return service.buscarTodos(idAnime);
  }

  @PostMapping("{idAnime}/episodios")
  @Operation(summary = "Adiciona um novo episódio")
  public String adicionarEpisodio(@PathVariable Long idAnime, @RequestBody EpisodioRequest dados) {
    service.adicionarNovo(idAnime, dados);
    return "O episódio '" + dados.titulo() + "' foi adicionado com sucesso.";
  }

  @PutMapping("/episodios/{idEpisodio}")
  @Operation(summary = "Atualiza o episódio pelo id")
  public String atualizarEpisodio(@PathVariable Long idEpisodio, @RequestBody EpisodioRequest dados) {
    service.atualizarEpisodio(idEpisodio, dados);
    return "O episódio '" + dados.titulo() + "' foi atualizado com sucesso.";
  }

  @DeleteMapping("/episodios/{idEpisodio}")
  @Operation(summary = "Remove o episódio pelo id")
  public String deletarEpisodio(@PathVariable Long idEpisodio) {
    service.deletarEpisodio(idEpisodio);
    return "O episódio foi removido com sucesso!";
  }
}
