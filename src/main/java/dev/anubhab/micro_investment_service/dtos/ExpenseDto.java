package dev.anubhab.micro_investment_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDto {
    private String date;
    private double amount;
}