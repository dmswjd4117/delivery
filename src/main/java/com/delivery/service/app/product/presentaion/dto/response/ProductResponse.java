package com.delivery.service.app.product.presentaion.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ProductResponse {

  @Schema(title = "상품 아이디")
  private Long id;

  @Schema(title = "상품 이름")
  private String name;

  @Schema(title = "상품 설명")
  private String description;

  @Schema(title = "상품 가격")
  private int price;

  @Schema(title = "남아 있는 재고")
  private int remain;
}