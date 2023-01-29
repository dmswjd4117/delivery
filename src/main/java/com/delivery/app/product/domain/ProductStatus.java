package com.delivery.app.product.domain;


public enum ProductStatus {

  ON("활성"),
  OFF("비활성"),
  SOLD_OUT("품절");

  private String status;

  ProductStatus(String status) {
    this.status = status;
  }

}
