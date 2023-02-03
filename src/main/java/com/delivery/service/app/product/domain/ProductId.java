package com.delivery.service.app.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductId implements Serializable {

  @Column(name = "product_id")
  private Long id;
}
