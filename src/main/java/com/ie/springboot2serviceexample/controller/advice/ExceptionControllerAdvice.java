package com.ie.springboot2serviceexample.controller.advice;

import com.ie.springboot2serviceexample.model.exception.ExceptionResponse;
import com.ie.springboot2serviceexample.model.exception.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<ExceptionResponse> handleHttpException(HttpException e) {
    exceptionLog(e);
    return ResponseEntity
        .status(e.getHttpStatus())
        .body(
            new ExceptionResponse(e.getMessage(), e.getDetailed())
        );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleUnpredictedExceptions(Exception e) {
    exceptionLog(e);
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ExceptionResponse(e.getMessage(), null)
        );
  }

  private void exceptionLog(Exception e) {
    log.warn(e.getMessage(), e);
  }

}
