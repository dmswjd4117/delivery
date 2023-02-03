package com.delivery.service.address.infrastructure;

import com.delivery.service.address.presentation.dto.request.AddressSearchRequest;
import com.delivery.service.address.presentation.dto.response.AddressSearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource("classpath:/application-test.properties")
class AddressRepositoryTest {

  @Autowired
  private AddressRepository addressRepository;

  @Test
  void test() {
    AddressSearchRequest addressSearchRequest = AddressSearchRequest.builder()
        .cityCountyName("종로구")
        .townName("청운동")
        .cityName("서울특별시")
//        .roadName("창의")
//        .zipCode("03046")
        .build();
    Page<AddressSearchResponse> addressSearchResponses = addressRepository.searchAddress(
        addressSearchRequest, PageRequest.ofSize(100));

    for (AddressSearchResponse searchResponse : addressSearchResponses) {
      System.out.println(searchResponse);
    }
  }
}