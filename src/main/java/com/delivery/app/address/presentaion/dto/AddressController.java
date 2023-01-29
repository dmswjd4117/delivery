package com.delivery.app.address.presentaion.dto;

import com.delivery.app.address.presentaion.dto.response.AddressResponse;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

  @GetMapping
  public AddressResponse search(String address){
    return new AddressResponse();
  }
}
