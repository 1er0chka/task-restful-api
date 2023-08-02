package com.example.task.mapper;

import com.example.task.DTO.UserDTO;
import com.example.task.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper {
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserMapper( BCryptPasswordEncoder bCryptPasswordEncoder) {
        UserMapper.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static UserEntity toEntity(UserDTO userDTO) {
        return new UserEntity(userDTO.getUsername(), bCryptPasswordEncoder.encode(userDTO.getPassword()));
    }

    public static UserDetails toUserDetails(UserEntity user){
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
