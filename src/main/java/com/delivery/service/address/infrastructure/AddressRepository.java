package com.delivery.service.address.infrastructure;

import static com.delivery.service.address.domain.QAddress.address;

import com.delivery.service.address.presentation.dto.request.AddressSearchRequest;
import com.delivery.service.address.presentation.dto.response.AddressSearchResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {

  @Autowired
  @Qualifier("addressJpaQueryFactory")
  private JPAQueryFactory jpaQueryFactory;

  public Page<AddressSearchResponse> searchAddress(AddressSearchRequest addressSearchRequest,
      Pageable pageable) {
    List<AddressSearchResponse> results = jpaQueryFactory
        .select(
            Projections.fields(AddressSearchResponse.class,
                address.townCode, address.cityName, address.cityCountyName, address.townName,
                address.roadNameCode, address.roadName, address.buildingNum, address.zipCode,
                address.buildingNameForCity
            )
        )
        .from(address)
        .where(
            eqCityName(addressSearchRequest.getCityName()),
            eqCityCountyName(addressSearchRequest.getCityCountyName()),
            eqTownName(addressSearchRequest.getTownName()),
            eqRoadName(addressSearchRequest.getRoadName()),
            eqZipCode(addressSearchRequest.getZipCode()),
            eqBuildingNameForCity(addressSearchRequest.getBuildingNameForCity())
        )
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

    JPAQuery<Long> countQuery = getCount(addressSearchRequest);
    return PageableExecutionUtils.getPage(results, pageable, countQuery::fetchOne);
  }

  private JPAQuery<Long> getCount(AddressSearchRequest addressSearchRequest) {
    return jpaQueryFactory
        .select(address.count())
        .from(address)
        .where(
            eqCityName(addressSearchRequest.getCityName()),
            eqCityCountyName(addressSearchRequest.getCityCountyName()),
            eqTownName(addressSearchRequest.getTownName()),
            eqRoadName(addressSearchRequest.getRoadName()),
            eqZipCode(addressSearchRequest.getZipCode()),
            eqBuildingNameForCity(addressSearchRequest.getBuildingNameForCity())
        );
  }

  private BooleanExpression eqCityName(String cityName) {
    if (StringUtils.isNullOrEmpty(cityName)) {
      return null;
    }
    return address.cityName.eq(cityName);
  }

  private BooleanExpression eqCityCountyName(String cityCountyName) {
    if (StringUtils.isNullOrEmpty(cityCountyName)) {
      return null;
    }
    return address.cityCountyName.eq(cityCountyName);
  }

  private BooleanExpression eqTownName(String townName) {
    if (StringUtils.isNullOrEmpty(townName)) {
      return null;
    }
    return address.townName.eq(townName);
  }

  private BooleanExpression eqRoadName(String roadName) {
    if (StringUtils.isNullOrEmpty(roadName)) {
      return null;
    }
    return address.roadName.contains(roadName);
  }

  private BooleanExpression eqZipCode(String zipCode) {
    if (StringUtils.isNullOrEmpty(zipCode)) {
      return null;
    }
    return address.zipCode.eq(zipCode);
  }

  private BooleanExpression eqBuildingNameForCity(String buildingNameForCity) {
    if (StringUtils.isNullOrEmpty(buildingNameForCity)) {
      return null;
    }
    return address.buildingNameForCity.eq(buildingNameForCity);
  }

}