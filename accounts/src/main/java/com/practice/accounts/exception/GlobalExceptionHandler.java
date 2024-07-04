package com.practice.accounts.exception;

import com.practice.accounts.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistException(CustomerAlreadyException exception, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false), HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDate.now());
        return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false), HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDate.now());
        return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
