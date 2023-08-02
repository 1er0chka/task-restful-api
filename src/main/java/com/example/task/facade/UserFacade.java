package com.example.task.facade;

import com.example.task.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface UserFacade {
    void createUser(UserDTO userDTO) throws Exception;

    UserDetails loadUserByUsername(String username);
}
