package dev.anubhab.micro_investment_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class TransactionDto {
    private String date;
    private String amount;
    private String ceiling;
    private String remanent;
}
