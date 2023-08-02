package com.example.task.facade;

import com.example.task.DTO.AccountDTO;
import org.springframework.stereotype.Component;

@Component
public interface AccountFacade {
    AccountDTO getAccountByUsername(String name) throws Exception;

    AccountDTO addCash(Double cash, String name) throws Exception;

    AccountDTO getCash(Double cash, String name) throws Exception;
}
