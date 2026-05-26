package dev.anubhab.micro_investment_service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anubhab.micro_investment_service.dtos.ExpenseDto;
import dev.anubhab.micro_investment_service.dtos.TransactionDto;
import dev.anubhab.micro_investment_service.dtos.TransactionValidationRequest;
import dev.anubhab.micro_investment_service.dtos.TransactionValidationResponse;
import dev.anubhab.micro_investment_service.logger.MicroserviceLogger;
import dev.anubhab.micro_investment_service.services.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class TransactionController {
    @Value("${spring.application.name}")
    private String SOURCE_NAME;
    private final MicroserviceLogger logger = new MicroserviceLogger(this.getClass().getSimpleName(), SOURCE_NAME);

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions:parse")
    public ResponseEntity<List<TransactionDto>> parseTransaction(@RequestBody JsonNode expenseData) {
        // Placeholder for transaction parsing logic
        logger.msInfo("Parse logic");
        if(!expenseData.isArray()) {
            throw new IllegalArgumentException();
        }

        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (JsonNode expenseNode: expenseData) {
            ExpenseDto expenseDto = objectMapper.convertValue(expenseNode, ExpenseDto.class);
            transactionDtoList.add(transactionService.extractionRemnant(expenseDto));
        }
        return ResponseEntity.ok(transactionDtoList);
    }

    @PostMapping("/transactions:validator")
    public ResponseEntity<TransactionValidationResponse> validateTransaction(@RequestBody TransactionValidationRequest transactionValidationRequest) {
        // Placeholder for transaction validation logic

        return ResponseEntity.ok(transactionService.validateTransaction(transactionValidationRequest.getTransactions()));
    }

    @PostMapping("/transactions:filter")
    public ResponseEntity<String> filterTransactions(@RequestBody String filterCriteria) {
        // Placeholder for transaction filtering logic
        return ResponseEntity.ok("Transactions filtered successfully");
    }
}
