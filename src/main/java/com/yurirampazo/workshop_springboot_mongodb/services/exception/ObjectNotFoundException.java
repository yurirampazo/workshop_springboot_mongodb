package com.yurirampazo.workshop_springboot_mongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ObjectNotFoundException(String msg) {
    super(msg);
  }
}
