package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe: MinhasSeriesService.
 */

@Service
public class MinhasSeriesService {
  @Autowired
  private SerieRepository serieRepository;

  public List<Serie> findAll() {
    return serieRepository.findAll();
  }

  /**
   * Método: Salvar série.
   */

  public Serie save(Serie serie) {
    if (serieRepository.existsByNome(serie.getNome())) {
      throw new SerieExistenteException("Série Existente");
    }
    return serieRepository.save(serie);
  }

  /**
   * Método: Deletar série.
   */

  public void delete(Integer id) {
    if (serieRepository.existsById(id)) {
      serieRepository.deleteById(id);
    } else {
      throw new SerieNaoEncontradaException("Série não encontrada");
    }
  }

  /**
   * Método: Adicionar Episódio.
   */

  public Serie addEpisode(Integer id, Episodio episodio) {
    Serie serie = serieRepository.findById(id).orElse(null);

    if (serie == null) {
      throw new SerieNaoEncontradaException("Série não encontrada");
    }

    List<Episodio> episodios = serie.getEpisodios();

    if (episodios.contains(episodio)) {
      throw new EpisodioExistenteException("Episódio Existente");
    }

    episodios.add(episodio);

    return serieRepository.save(serie);
  }

  /**
   * Método: Listar Episódios.
   */

  public List<Episodio> listar(Integer id) {
    Serie serie = serieRepository.findById(id).orElse(null);

    if (serie == null) {
      throw new SerieNaoEncontradaException("Série não encontrada");
    }

    return serie.getEpisodios();
  }

  /**
   * Método: Calcular Tempo Total de Minutos.
   */

  public Map<String, Integer> tempoEmMinutos() {
    int tempoEmMinutos = 0;
    List<Serie> series = serieRepository.findAll();

    for (Serie serie : series) {
      for (Episodio episodio : serie.getEpisodios()) {
        tempoEmMinutos += episodio.getDuracaoEmMinutos();
      }
    }
    return Map.of("tempoEmMinutos", tempoEmMinutos);
  }

}


