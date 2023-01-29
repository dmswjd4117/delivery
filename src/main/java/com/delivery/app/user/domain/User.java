package com.delivery.app.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

  @EmbeddedId
  private UserId userId;

  private String email;

  private String password;

  private String name;

  @OneToMany(mappedBy = "user")
  private List<DeliveryLocation> deliveryLocations;
}
