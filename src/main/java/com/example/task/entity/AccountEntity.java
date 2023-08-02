package com.example.task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    public AccountEntity(Double balance, UserEntity user) {
        this.balance = balance;
        this.user = user;
    }
}
