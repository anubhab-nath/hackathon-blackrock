package dev.anubhab.micro_investment_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TransactionValidationResponse {
    private List<TransactionDto> valid;
    private List<TransactionDto> invalid;

    public TransactionValidationResponse(List<TransactionDto> transactionDtoList) {
        this.valid = new ArrayList<>();
        this.invalid = new ArrayList<>();
        for(TransactionDto transactionDto: transactionDtoList) {
            if(transactionDto.getMessage() == null) {
                this.valid.add(transactionDto);
            } else {
                this.invalid.add(transactionDto);
            }
        }
    }
}
