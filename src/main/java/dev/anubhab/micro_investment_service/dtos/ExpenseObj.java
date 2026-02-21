package dev.anubhab.micro_investment_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseObj {
    private String date;
    private Double amount;
}
