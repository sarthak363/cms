package com.sarthak.cls.api;

import com.sarthak.cls.exception.AppplicationError;
import com.sarthak.cls.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ErrorHandler {
    @Value("${api_doc_url}")
    private String details;
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<AppplicationError> HandleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest webRequest){
       AppplicationError error=new AppplicationError();
       error.setCode(101);
       error.setMessage(ex.getMessage());
       error.setDetails(details);
      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
