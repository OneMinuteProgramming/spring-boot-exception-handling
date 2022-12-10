package com.live.code.spring_boot_exception_handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicationCustomerRecordsException extends ApplicationException{

    public DuplicationCustomerRecordsException() {
        super("ERR002","Duplicated customer", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
