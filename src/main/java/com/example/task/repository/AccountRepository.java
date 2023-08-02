package com.example.task.repository;

import com.example.task.entity.AccountEntity;
import com.example.task.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findAccountEntityByUser(UserEntity user);
}
