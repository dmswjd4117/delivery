package com.delivery.app.address.infrastructure;

import com.delivery.app.address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {

}
