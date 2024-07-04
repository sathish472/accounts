package com.practice.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {
    private long accountNumber;
    private String accountType;
    private String branchAddress;
}
