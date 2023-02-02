package com.delivery.service.app.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class DeliveryAddress {

  private String zipCode;
  private String addressDetail;
}
