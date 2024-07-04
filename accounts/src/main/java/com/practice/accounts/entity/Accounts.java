package com.practice.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Accounts extends BaseEntity {
    @Id
    private long accountNumber;
    private long customerId;
    private String accountType;
    private String branchAddress;

}
