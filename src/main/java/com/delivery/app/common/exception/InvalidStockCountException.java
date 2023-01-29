package com.delivery.app.common.exception;

import java.util.Objects;

public class InvalidStockCountException extends RuntimeException {
  public InvalidStockCountException(Long value) {
    super(value+": 잘못된 재고 수량입니다.");
  }
}
