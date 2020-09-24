package com.demo.loanApplicationSystem.dto;

import com.demo.loanApplicationSystem.service.api.LoanApplicationSystemService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanApplicationUserDto {
    private String identityNumber;
    private String userName;
    private Double monthlyIncome;
    private String phoneNumber;
    private Boolean result ;

    public LoanApplicationUserDto(){

    }

    public LoanApplicationUserDto(String identityNumber, String userName, Double monthlyIncome, String phoneNumber, Boolean result){
        this.identityNumber = identityNumber;
        this.userName = userName;
        this.monthlyIncome = monthlyIncome;
        this.phoneNumber = phoneNumber;
        this.result = result;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
