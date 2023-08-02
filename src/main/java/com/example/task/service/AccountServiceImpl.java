package com.example.task.service;

import com.example.task.entity.AccountEntity;
import com.example.task.entity.UserEntity;
import com.example.task.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public AccountEntity getAccountByUsername(UserEntity user) throws Exception {
        AccountEntity account = repository.findAccountEntityByUser(user);
        if (account == null) {
            throw new Exception("Account not found");
        }
        return account;
    }

    @Override
    public AccountEntity createAccount(AccountEntity account) {
        return repository.save(account);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account) {
        return repository.save(account);
    }

}
