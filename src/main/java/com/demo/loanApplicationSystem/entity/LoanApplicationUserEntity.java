package com.demo.loanApplicationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public interface LoanApplicationUserEntity {
    String getIdentityNumber();
    void setIdentityNumber(String identityNumber);

    String getUserName();
    void setUserName(String userName);

    Double getMonthlyIncome();
    void setMonthlyIncome(Double monthlyIncome);

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);

}
