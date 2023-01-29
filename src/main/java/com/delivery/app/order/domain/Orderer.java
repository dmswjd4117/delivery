package com.delivery.app.order.domain;

import com.delivery.app.user.domain.UserId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderer {

  @Embedded
  @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
  private UserId userId;

  @Column(name = "orderer_name")
  private String name;
}
