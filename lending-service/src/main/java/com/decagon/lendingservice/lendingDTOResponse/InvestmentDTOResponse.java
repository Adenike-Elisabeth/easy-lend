package com.decagon.lendingservice.lendingDTOResponse;

import com.decagon.lendingservice.entity.InvestmentPreference;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class InvestmentDTOResponse {
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private int riskTolerance;
    private int durationInDays;

    public InvestmentDTOResponse(InvestmentPreference savedPreference) {
        this.loanAmount = savedPreference.getLoanAmount();
        this.interestRate = savedPreference.getInterestRate();
        this.riskTolerance = savedPreference.getRiskTolerance();
        this.durationInDays = savedPreference.getDurationInDays();
    }


}
