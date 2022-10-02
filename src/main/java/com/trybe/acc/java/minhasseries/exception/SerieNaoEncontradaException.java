package com.trybe.acc.java.minhasseries.exception;

/**
 * Classe: SerieNaoEncontradaException.
 */

@SuppressWarnings("serial")
public class SerieNaoEncontradaException extends RuntimeException {
  public SerieNaoEncontradaException(String message) {
    super(message);
  }
}
