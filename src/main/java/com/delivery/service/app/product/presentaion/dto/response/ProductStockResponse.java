package com.delivery.service.app.product.presentaion.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;

@Getter
public class ProductStockResponse {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(title = "재고수량 아이디")
  private Long id;

  @Schema(title = "총 재고수량")
  private Long total;

  @Schema(title = "남아 있는 재고",
      description = "실시간 재고 아님(실시간 재고 조회하려면 refresh api 호출 필요함)")
  private Long remain;

}
