package com.delivery.service.address.dto;

import com.delivery.service.address.dto.response.AddressSearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

  @GetMapping
  public AddressSearchResponse search(String address){
    return new AddressSearchResponse();
  }
}
