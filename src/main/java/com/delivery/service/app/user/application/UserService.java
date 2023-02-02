package com.delivery.service.app.user.application;

import com.delivery.service.app.user.domain.User;
import com.delivery.service.app.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User me(Long id){
    return userRepository.findById(id)
        .orElseThrow(RuntimeException::new);
  }

}
