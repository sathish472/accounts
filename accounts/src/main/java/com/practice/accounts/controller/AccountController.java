package com.practice.accounts.controller;

import com.practice.accounts.constans.AccountConstants;
import com.practice.accounts.dto.CustomerDTO;
import com.practice.accounts.dto.ResponseDTO;
import com.practice.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCount(@Valid @RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.STATUS_201_MESSAGE));
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp = "(^$|[0-9]){10}", message="Invalid mobile number.")
                                                               String mobileNumber) {

        return ResponseEntity.status(HttpStatus.OK).body(accountService.fetchAccount(mobileNumber));

    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        if (accountService.updateAccount(customerDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.STATUS_200_MESSAGE));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.STATUS_200_MESSAGE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccount(@RequestParam
                                                         @Pattern(regexp = "(^$|[0-9]){10}", message="Invalid mobile number.")
                                                         String mobileNumber) {
        if (accountService.deleteAccount(mobileNumber)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.STATUS_200_MESSAGE));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.STATUS_200_MESSAGE));
        }

    }


}
