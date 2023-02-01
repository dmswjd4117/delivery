package com.delivery.app;

import com.delivery.app.address.domain.Address;
import com.delivery.app.address.infrastructure.AddressRepository;
import com.delivery.app.user.domain.User;
import com.delivery.app.user.infrastructure.UserRepository;
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
