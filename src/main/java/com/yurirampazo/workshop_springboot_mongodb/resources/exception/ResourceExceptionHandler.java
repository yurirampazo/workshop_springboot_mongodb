package com.yurirampazo.workshop_springboot_mongodb.resources.exception;

import com.yurirampazo.workshop_springboot_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(
          System.currentTimeMillis(), status.value(), "Não Encontrado"
          , e.getMessage(), request.getRequestURI()
    );
    return ResponseEntity.status(status).body(err);
  }
}
