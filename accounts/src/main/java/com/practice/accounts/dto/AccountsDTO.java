package com.practice.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {
    @Pattern(regexp = "(^$|[0-9]){10}", message="Invalid accountNumber.")
    private Long accountNumber;
    @NotEmpty(message="accountType should not empty")
    private String accountType;
    @NotEmpty(message="branchAddress should not empty")
    private String branchAddress;
}
