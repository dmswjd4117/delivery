package com.delivery.app;

import com.delivery.address.infrastructure.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class AppApplicationTests {

//	@Aƒutowired
//	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

//	@Test
//	void contextLoads() {
//		User user = new User("email", "password", "name");
//		userRepository.save(user);
//	}

	@Test
	void address(){
	}
}
