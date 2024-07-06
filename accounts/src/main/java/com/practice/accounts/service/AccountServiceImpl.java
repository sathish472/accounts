package com.practice.accounts.service;

import com.practice.accounts.constans.AccountConstants;
import com.practice.accounts.dto.AccountsDTO;
import com.practice.accounts.dto.CustomerDTO;
import com.practice.accounts.entity.Accounts;
import com.practice.accounts.entity.Customer;
import com.practice.accounts.exception.CustomerAlreadyException;
import com.practice.accounts.exception.ResourceNotFoundException;
import com.practice.accounts.mapper.AccountMapper;
import com.practice.accounts.mapper.CustomerMapper;
import com.practice.accounts.repository.AccountsRepository;
import com.practice.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    public AccountsRepository accountsRepository;
    public CustomerRepository customerRepository;


    /**
     * @param customerDTO
     */
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyException("Customer already exist with this mobile number" + customer.getMobileNumber());
        }
        customer.setCreatedAt(LocalDate.now());
        customer.setCreatedBy("Satish");
        Customer savedCustomer = customerRepository.save(customer);
        Accounts account = createNewAccount(savedCustomer);
        accountsRepository.save(account);
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long accountNumber = 10000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(accountNumber);
        newAccount.setAccountType(AccountConstants.SAVING);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDate.now());
        newAccount.setCreatedBy("Satish");
        return newAccount;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> {
            throw new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber);
        });
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()-> {
            throw new ResourceNotFoundException("Account", "Customer id", customer.getCustomerId().toString());
        });

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
      customerDTO.setAccountsDTO(AccountMapper.mapToAccountsDTO(account, new AccountsDTO()));

        return customerDTO;
    }

    /**
     * @param customerDTO
     * @return
     */
    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdate = false;
        if(customerDTO!=null) {
            AccountsDTO accountsDTO = customerDTO.getAccountsDTO();
            if (accountsDTO != null) {
                Accounts account = accountsRepository.findById(accountsDTO.getAccountNumber()).orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", accountsDTO.getAccountNumber().toString()));
                AccountMapper.mapToAccounts(accountsDTO, account);
                account = accountsRepository.save(account);

                Long customerId = account.getCustomerId();

                Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
                CustomerMapper.mapToCustomer(customerDTO, customer);
                customerRepository.save(customer);
                isUpdate = true;
            }
        }
        return isUpdate;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        boolean isDelete= false;
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
