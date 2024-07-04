package com.practice.accounts.mapper;

import com.practice.accounts.dto.CustomerDTO;
import com.practice.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
}
