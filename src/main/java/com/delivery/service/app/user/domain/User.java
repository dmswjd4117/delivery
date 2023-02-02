package com.delivery.service.app.user.domain;

import jakarta.persistence.Column;
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

  @Getter(AccessLevel.NONE)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Long id;

  private String email;

  private String password;

  private String name;

  @OneToMany(mappedBy = "user")
  private List<DeliveryLocation> deliveryLocations;

  public void setId(Long id) {
    this.id = id;
  }

  public User(String email, String password, String name) {
    this.email = email;
    this.password = password;
    this.name = name;
  }
}
