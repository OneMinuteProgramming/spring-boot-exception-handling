package com.live.code.spring_boot_exception_handling.exception;


import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class ApplicationException extends RuntimeException {

    protected String errorCode;

    protected HttpStatusCode htpStatusCode;

    public ApplicationException(String message, String errorCode, HttpStatusCode htpStatusCode) {
        super(message);
        this.errorCode = errorCode;
        this.htpStatusCode = htpStatusCode;
    }
}
