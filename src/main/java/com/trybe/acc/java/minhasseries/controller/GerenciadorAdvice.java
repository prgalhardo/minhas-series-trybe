package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.ErroInesperadoException;
import com.trybe.acc.java.minhasseries.exception.Error;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe: GerenciadorAdvice.
 */

@ControllerAdvice
public class GerenciadorAdvice {

  /**
   * Método: Erro 409 - Série/Episódio já existente.
   **/

  @ExceptionHandler({SerieExistenteException.class, EpisodioExistenteException.class})
  public ResponseEntity<Error> handleSerieExistenteException(RuntimeException exception) {
    Error error = new Error(exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(error);
  }

  /**
   * Método: Erro 404 - Série não encontrada.
   **/

  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<Error> handleSerieNaoEncontradaException(RuntimeException exception) {
    Error error = new Error(exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(error);
  }

  /**
   * Método: Erro 500 - Erros não mapeados.
   **/

  @ExceptionHandler(ErroInesperadoException.class)
  public ResponseEntity<Error> handleErroInesperadoException(RuntimeException exception) {
    Error error = new Error(exception.getMessage());
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(error);
  }
}
