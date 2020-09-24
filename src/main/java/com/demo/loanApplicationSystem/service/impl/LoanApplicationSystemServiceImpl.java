package com.demo.loanApplicationSystem.service.impl;

import com.demo.loanApplicationSystem.dto.LoanApplicationUserDto;
import com.demo.loanApplicationSystem.service.api.LoanApplicationSystemService;

public class LoanApplicationSystemServiceImpl implements LoanApplicationSystemService {
    public Boolean calculateLoanScore(LoanApplicationUserDto loanApplicationUserDto) {
        boolean scoreResult = false;
        String userName = loanApplicationUserDto.getUserName();
        String identityNumber = loanApplicationUserDto.getIdentityNumber();
        Double monthlyIncome = loanApplicationUserDto.getMonthlyIncome();
        String phoneNumber = loanApplicationUserDto.getPhoneNumber();

        /*Calculate Score

          Score Rules
         */

        return true;
    }
}
