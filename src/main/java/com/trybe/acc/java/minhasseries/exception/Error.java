package com.trybe.acc.java.minhasseries.exception;

/**
 * Classe: Error.
 */

@SuppressWarnings("serial")
public class Error {

  /**
   * Atributos.
   */
  public String error;

  public Error(String error) {
    this.error = error;
  }

  /**
   * Métodos.
   */

  public String getError() {
    return error;
  }

}
