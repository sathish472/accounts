package com.practice.accounts.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
