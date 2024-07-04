package com.practice.accounts.service;

import com.practice.accounts.dto.CustomerDTO;

public interface IAccountService {

    /**
     * @param customerDTO
     */
    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccount(String mobileNumber);
}
