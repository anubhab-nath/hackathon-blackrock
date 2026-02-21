package dev.anubhab.micro_investment_service.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.beans.Transient;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {
    private String date;
    private double amount;
    private double ceiling;
    private double remanent;
    private String message;

    @Transient
    public boolean isValidAmount() {
        return this.amount > 0.0;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
