package com.delivery.app.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;

@Embeddable
@Getter
public class OrderId implements Serializable {

  @Column(name = "order_id")
  private Long id;
}
