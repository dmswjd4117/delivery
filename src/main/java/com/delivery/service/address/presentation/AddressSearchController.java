package com.delivery.service.address.presentation;

import com.delivery.service.address.infrastructure.AddressRepository;
import com.delivery.service.address.presentation.dto.request.AddressSearchRequest;
import com.delivery.service.address.presentation.dto.response.AddressSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressSearchController {

  private final AddressRepository addressRepository;


  public AddressSearchController(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @GetMapping
  public ResponseEntity<Page<AddressSearchResponse>> searchAddress(
      @PageableDefault Pageable pageable,
      @RequestBody AddressSearchRequest addressSearchRequest) {
    return ResponseEntity.ok(addressRepository.searchAddress(addressSearchRequest, pageable));
  }
}
