package edu.icet.crm.exception;

import edu.icet.crm.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<ErrorResponse>handleCustomerNotFoundException(CustomerNotFoundException ex){
        log.debug("Customer Not Found Error|{}",ex.getMessage());
        ErrorResponse customerNotFound = ErrorResponse.builder().errorMessage(ex.getMessage()).status("Failed").build();
        return ResponseEntity.ok().body(customerNotFound);
    }

    @ExceptionHandler(InvalidParameterException.class)
    ResponseEntity<ErrorResponse>handleInvalidParameterException(InvalidParameterException ex){
        log.debug("Invalid Parameter Error|{}",ex.getMessage());
        ErrorResponse invalidParameter = ErrorResponse.builder().errorMessage(ex.getMessage()).status("Failed").build();
        return ResponseEntity.ok().body(invalidParameter);
    }

}
