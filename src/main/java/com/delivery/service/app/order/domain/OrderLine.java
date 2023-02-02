package com.delivery.service.app.order.domain;

import com.delivery.service.app.product.domain.ProductId;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;


@Entity
@Getter
public class OrderLine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_line_id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @Embedded
  private ProductId productId;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "price")
  private long price;

  @Column(name = "count")
  private int count;

}
