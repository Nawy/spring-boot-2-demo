package com.ie.springboot2serviceexample.model.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends HttpException {

  public InternalServerErrorException(String message, String detailed) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, message, detailed);
  }

  public InternalServerErrorException(String message) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
  }
}
