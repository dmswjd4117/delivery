package com.delivery.app.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@ToString
@Entity(name = "orders")
public class Order {

  @EmbeddedId
  private OrderId orderId;

  @NotNull
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private OrderStatus state;

  @Embedded
  private Orderer orderer;

  @Embedded
  private DeliveryAddress deliveryAddress;

  @OneToMany(mappedBy = "order")
  private List<OrderLine> orderLines = new ArrayList<>();

}
