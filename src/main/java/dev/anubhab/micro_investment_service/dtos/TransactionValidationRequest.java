package dev.anubhab.micro_investment_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionValidationRequest {
    private Double wage;
    private List<TransactionDto> transactions;
}
