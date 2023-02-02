package com.delivery.service.app.order.domain;

public enum OrderStatus {
  WAITING("접수전"),
  ACCEPTED("접수됨"),
  DELIVERING("배달중"),
  DELIVERY_COMPLETED("배달완료");

  private String info;

  OrderStatus(String info) {
    this.info = info;
  }


}
