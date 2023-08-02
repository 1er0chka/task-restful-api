package com.example.task.service;

import com.example.task.entity.UserEntity;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    @Override
    public void createUser(UserEntity user) throws Exception {
        if (repository.findByUsername(user.getUsername()) == null){
            repository.save(user);
        } else {
            throw new Exception("User is exist");
        }
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        repository.save(user);
        return user;
    }

}
