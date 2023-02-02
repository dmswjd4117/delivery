package com.delivery.service.address.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AddressSearchResponse {

  @Schema(title = "주소관할읍면동코드",
      description = "시군구코드(5)+읍면동코드(3)+00)")
  private String townCode;

  @Schema(title = "시도")
  private String cityName;

  @Schema(title = "시군구명")
  private String cityCountyName;

  @Schema(title = "읍면동명")
  private String townName;

  @Schema(title = "도로명 코드")
  private String roadNameCode;

  @Schema(title = "도로명")
  private String roadName;

  @Schema(title = "건물본번")
  private Integer buildingNum;

  @Schema(title = "건물부번")
  private Integer buildingSideNum;

  @Schema(title = "우편번호")
  private String zipCode;

}