package com.example.task.facade;

import com.example.task.DTO.UserDTO;
import com.example.task.entity.AccountEntity;
import com.example.task.entity.UserEntity;
import com.example.task.mapper.UserMapper;
import com.example.task.service.AccountService;
import com.example.task.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {
    private final UserService service;
    private final AccountService accountService;

    public UserFacadeImpl(UserService userService, AccountService accountService) {
        this.service = userService;
        this.accountService = accountService;
    }

    @Override
    public void createUser(UserDTO userDTO) throws Exception {
        UserEntity newUser = UserMapper.toEntity(userDTO);
        service.createUser(newUser);
        AccountEntity account = new AccountEntity(0.0, newUser);
        accountService.createAccount(account);
        newUser.setAccount(account);
        service.updateUser(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserMapper.toUserDetails(service.loadUserByUsername(username));
    }
}
