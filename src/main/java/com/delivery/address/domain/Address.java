package com.delivery.address.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity(name = "address")
@Getter
@ToString
public class Address {

  @Id
  private String buildingManagementNum;

  private String townCode;

  private String cityName;

  private String cityCountyName;

  private String townName;

  private String roadNameCode;

  private String roadName;

  private String undergroundStatus;

  private Integer buildingNum;

  private Integer buildingSideNum;

  private String zipCode;

  private String buildingNameForCity;

  private String buildingUseClassification;

  private String administrativeTownCode;

  private String administrativeTownName;

  private Integer groundFloorNumber;

  private Integer undergroundFloorNumber;

  private String classificationApartmentBuildings;

  private Integer buildingCnt;

  private String detailBuildingName;

  private String buildingNameChangeHistory;

  private String buildingNameChangeHistoryDetail;

  private String livingStatus;

  private Double buildingCenterXCoordinate;

  private Double buildingCenterYCoordinate;

  private Double exitXCoordinate;

  private Double exitYCoordinate;

  private String cityNameEng;

  private String cityCountyNameEng;

  private String townNameEng;

  private String roadNameEng;

  private String townMobileClassification;

  private String mobileReasonCode;

}
