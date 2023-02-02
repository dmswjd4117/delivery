package com.delivery.service.app.user.infrastructure;

import com.delivery.service.app.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
