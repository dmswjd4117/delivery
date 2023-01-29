package com.delivery.app.user.infrastructure;

import com.delivery.app.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
