package com.example.task.service;

import com.example.task.entity.AccountEntity;
import com.example.task.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountEntity getAccountByUsername(UserEntity userEntity) throws Exception;

    AccountEntity createAccount(AccountEntity account);

    AccountEntity updateAccount(AccountEntity account);

}
