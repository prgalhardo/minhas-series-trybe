package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.MinhasSeriesService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe: MinhasSeriesController.
 */

@RestController
@RequestMapping(value = "/series")
public class MinhasSeriesController {
  @Autowired
  private MinhasSeriesService minhasSeriesService;

  @GetMapping
  public List<Serie> findAll() {
    return minhasSeriesService.findAll();
  }

  @PostMapping
  public Serie save(@RequestBody Serie serie) {
    return minhasSeriesService.save(serie);
  }

  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable("id") Integer id) {
    minhasSeriesService.delete(id);
  }

  @PostMapping(value = "/{id}/episodios")
  public Serie addEpisode(@PathVariable Integer id, @RequestBody Episodio episodio) {
    return minhasSeriesService.addEpisode(id, episodio);
  }

  @GetMapping(value = "/{id}/episodios")
  public List<Episodio> listar(@PathVariable("id") Integer id) {
    return minhasSeriesService.listar(id);
  }

  @GetMapping(value = "/tempo")
  public Map<String, Integer> tempoEmMinutos() {
    return minhasSeriesService.tempoEmMinutos();
  }
}
