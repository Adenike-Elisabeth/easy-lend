package com.decagon.loanagreementservice.services;

import com.decagon.loanagreementservice.dtos.request.LoanAgreementDto;
import com.decagon.loanagreementservice.models.LoanOffer;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface BorrowerService {
    LoanAgreementDto selectLoanOffer(String loanId, HttpServletRequest request);
    LoanOffer getLoanOffer(String offerId);
    List<LoanOffer> getAllLoanoffer();
}
