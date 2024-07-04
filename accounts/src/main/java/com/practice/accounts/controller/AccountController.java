package com.practice.accounts.controller;

import com.practice.accounts.constans.AccountConstants;
import com.practice.accounts.dto.CustomerDTO;
import com.practice.accounts.dto.ResponseDTO;
import com.practice.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCount(@RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.STATUS_201_MESSAGE));
    }

    @RequestMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobileNumer){


    }

}
