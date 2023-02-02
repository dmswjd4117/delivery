package com.delivery.service.address.infrastructure;

import static com.delivery.service.address.domain.QAddress.address;

import com.delivery.service.address.domain.Address;
import com.delivery.service.address.dto.request.AddressSearchRequest;
import com.delivery.service.address.dto.response.AddressSearchResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("addressEntityManger")
@Repository
public class AddressRepository {

  @Autowired
  @Qualifier("addressJpaQueryFactory")
  private JPAQueryFactory jpaQueryFactory;

  public AddressSearchResponse searchAddress(AddressSearchRequest addressSearchRequest) {
    Address res = jpaQueryFactory
        .selectFrom(address)
        .where(address.cityName.eq("서울특별시"))
        .limit(1)
        .fetchOne();
    return null;
  }
}

//public interface AddressRepository extends JpaRepository<Address, String> {
//}