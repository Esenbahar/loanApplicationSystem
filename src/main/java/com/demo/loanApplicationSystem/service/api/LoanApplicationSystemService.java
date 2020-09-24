package com.demo.loanApplicationSystem.service.api;

import com.demo.loanApplicationSystem.dto.LoanApplicationUserDto;


public interface LoanApplicationSystemService {
    Boolean calculateLoanScore(LoanApplicationUserDto loanApplicationUserDto);
}
