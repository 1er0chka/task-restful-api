package com.example.task.controller;

import com.example.task.DTO.CashDTO;
import com.example.task.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class AppRestController {
    private final AccountFacade facade;

    public AppRestController(@Qualifier("accountFacadeImpl") AccountFacade facade) {
        this.facade = facade;
    }

    @GetMapping(value = "/getBalance")
    public ResponseEntity<?> getAccountBalance(Authentication user) {
        try {
            return ResponseEntity.ok(facade.getAccountByUsername(user.getName()));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/addCash")
    public ResponseEntity<?> addCash(@RequestBody CashDTO cash, Authentication user) {
        try {
            String username = user.getName();
            return ResponseEntity.ok(facade.addCash(cash.getCount(), username));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to add cash: " + e.getMessage());
        }
    }

    @PutMapping(value = "/getCash")
    public ResponseEntity<?> getCash(@RequestBody CashDTO cash, Authentication user) {
        try {
            String username = user.getName();
            return ResponseEntity.ok(facade.getCash(cash.getCount(), username));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to get cash: " + e.getMessage());
        }
    }
}
