package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity: Episodio.
 */

@Entity
public class Episodio {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer numero;
  private Integer duracaoEmMinutos;

  @ManyToOne
  @JoinColumn(name = "serie_id")
  private Serie serie;

  public Episodio(Integer numero, Integer duracaoEmMinutos, Serie serie) {
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  public Episodio() {}

  /**
   * Métodos.
   */

  public Long getId() {
    return id;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }
}
