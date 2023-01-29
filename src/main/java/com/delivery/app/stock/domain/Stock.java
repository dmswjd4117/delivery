package com.delivery.app.stock.domain;

import com.delivery.app.common.exception.InvalidStockCountException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private Long total;

  @NotNull
  @Column
  private Long remain;

  private Stock(Long total, Long remain) {
    validateStock(total);
    validateStock(remain);
    this.total = total;
    this.remain = remain;
  }

  private static void validateStock(long total) {
    if (total < 1L) {
      throw new InvalidStockCountException(total);
    }
  }

  public static Stock of(long total) {
    return new Stock(total, total);
  }

  public void increase(long value) {
    validateStock(value);

    long nextTotal = total + value;
    long nextRemain = remain + value;
    validateStock(nextTotal);
    validateStock(nextRemain);

    this.total = nextTotal;
    this.remain = nextRemain;
  }

  public void decrease(long value) {
    validateStock(value);

    long nextTotal = total - value;
    long nextRemain = remain - value;
    validateStock(nextTotal);
    validateStock(nextRemain);

    this.total = nextTotal;
    this.remain = nextRemain;
  }

  public void syncRemainValue(long value) {
    validateStock(value);

    this.remain = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Stock stock = (Stock) o;
    return id != null && Objects.equals(id, stock.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
