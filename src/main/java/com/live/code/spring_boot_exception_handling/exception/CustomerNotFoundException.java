package com.live.code.spring_boot_exception_handling.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends ApplicationException{

    public CustomerNotFoundException() {
        super("ERR001","Customer size is 0", HttpStatus.CONFLICT);
    }
}
