package com.delivery.service.app.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderer {

  @Column(name = "orderer_id")
  private Long userId;

  @Column(name = "orderer_name")
  private String name;
}
