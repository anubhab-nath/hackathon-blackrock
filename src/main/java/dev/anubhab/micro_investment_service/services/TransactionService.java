package dev.anubhab.micro_investment_service.services;

import dev.anubhab.micro_investment_service.dtos.ExpenseDto;
import dev.anubhab.micro_investment_service.dtos.TransactionDto;
import dev.anubhab.micro_investment_service.dtos.TransactionValidationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());


    public TransactionDto extractionRemnant(ExpenseDto expenseDto) {
        double amount = expenseDto.getAmount();
        double mod = amount % 100;
        logger.info(String.valueOf(mod));
        double remnant = 100 - mod;
        double ceiling = amount + remnant;

        return TransactionDto.builder()
                .date(expenseDto.getDate())
                .amount(expenseDto.getAmount())
                .ceiling(ceiling)
                .remanent(remnant)
                .build();
    }

    public TransactionValidationResponse validateTransaction(List<TransactionDto> transactionDtoList) {
        for(TransactionDto transactionDto: transactionDtoList) {
            if(!transactionDto.isValidAmount()) {
                transactionDto.setMessage("Negative amounts are not allowed");
            }
        }

        return new TransactionValidationResponse(transactionDtoList);
    }
}
