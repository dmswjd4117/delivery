package com.delivery.service.app.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductId implements Serializable {

  private static final long serialVersionUID = -3333412011971401918L;
  @Column(name = "product_id")
  private Long id;
}
