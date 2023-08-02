package com.example.task.mapper;

import com.example.task.DTO.AccountDTO;
import com.example.task.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static AccountDTO toDTO(AccountEntity account) {
        return new AccountDTO(account.getBalance());
    }
}
