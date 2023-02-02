package com.delivery.service.app.product.domain;

import com.delivery.service.app.stock.domain.Stock;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

  @EmbeddedId
  private ProductId productId;

  @Column(nullable = false)
  private String name;

  private String description;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private Stock stock;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
}
