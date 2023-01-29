package com.delivery.app.common.exception;

import lombok.Getter;

@Getter
public class ServiceRuntimeException extends RuntimeException {
  private final String message;
  private final Object[] params;

  protected ServiceRuntimeException(String message, Object[] params) {
    this.message = message;
    this.params = params;
  }
}