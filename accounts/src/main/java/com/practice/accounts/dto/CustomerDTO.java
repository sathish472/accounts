package com.practice.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    private long customerId;
    @NotEmpty(message = "Name cannot be empty.")
    @Size(min=5, max = 30, message = "Length of name should be betwwen 5 and 30")
    private String name;
    @NotEmpty(message = "email cannot be empty.")
    @Email(message = "Email shoild be valid")
    private String email;
    @NotEmpty(message = "mobileNumber cannot be empty.")
    @Pattern(regexp = "(^$|[0-9]){10}", message="Invalid mobile number.")
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
