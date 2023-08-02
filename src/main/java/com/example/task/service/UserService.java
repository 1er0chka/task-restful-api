package com.example.task.service;

import com.example.task.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    void createUser(UserEntity entity) throws Exception;

    UserEntity loadUserByUsername(String username) throws UsernameNotFoundException;

    UserEntity updateUser(UserEntity user);
}
