package com.delivery.service.address.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class AddressSearchRequest {

  @Schema(name = "시도명", example = "서울특별시")
  private String cityName;

  @Schema(name = "시군구명", example = "종로구")
  private String cityCountyName;

  @Schema(name = "읍면동명", example = "청운동")
  private String townName;

  @Schema(name = "도로명", example = "지하문로36길")
  private String roadName;

  @Schema(name = "우편번호", example = "03046")
  private String zipCode;

  @Schema(name = "건물명", example = "청운동 한옥문화 도서관")
  private String buildingNameForCity;
}
