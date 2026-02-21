package dev.anubhab.micro_investment_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class TransactionDto {
    private String date;
    private double amount;
    private double ceiling;
    private double remanent;
}
