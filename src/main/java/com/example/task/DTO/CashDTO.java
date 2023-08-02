package com.example.task.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashDTO {
    @Digits(integer = 100, fraction = 2)
    private Double count;
}
