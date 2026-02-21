package dev.anubhab.micro_investment_service.services;

import dev.anubhab.micro_investment_service.dtos.ExpenseDto;
import dev.anubhab.micro_investment_service.dtos.TransactionDto;
import org.springframework.stereotype.Service;

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
}
