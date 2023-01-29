package com.delivery.app.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class DeliveryAddress {

  private String zipCode;
  private String addressDetail;
}
