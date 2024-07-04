package com.practice.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDate errorTime;
}
