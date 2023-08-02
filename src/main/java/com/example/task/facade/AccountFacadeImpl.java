package com.example.task.facade;

import com.example.task.DTO.AccountDTO;
import com.example.task.entity.AccountEntity;
import com.example.task.mapper.AccountMapper;
import com.example.task.service.AccountService;
import com.example.task.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountFacadeImpl implements AccountFacade {
    private final AccountService service;
    private final UserService userService;

    public AccountFacadeImpl(@Qualifier("accountServiceImpl") AccountService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @Override
    public AccountDTO getAccountByUsername(String username) throws Exception {
        AccountEntity account = service.getAccountByUsername(userService.loadUserByUsername(username));
        return AccountMapper.toDTO(account);
    }

    @Override
    public AccountDTO addCash(Double cash, String username) throws Exception {
        AccountEntity account = service.getAccountByUsername(userService.loadUserByUsername(username));
        account.setBalance(account.getBalance() + cash);
        return AccountMapper.toDTO(service.updateAccount(account));
    }

    @Override
    public AccountDTO getCash(Double cash, String username) throws Exception {
        AccountEntity account = service.getAccountByUsername(userService.loadUserByUsername(username));
        account.setBalance(account.getBalance() - cash);
        return AccountMapper.toDTO(service.updateAccount(account));
    }
}
