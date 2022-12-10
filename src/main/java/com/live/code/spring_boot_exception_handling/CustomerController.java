package com.live.code.spring_boot_exception_handling;

import com.live.code.spring_boot_exception_handling.exception.ApplicationException;
import com.live.code.spring_boot_exception_handling.exception.CustomerNotFoundException;
import com.live.code.spring_boot_exception_handling.exception.DuplicationCustomerRecordsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Live Code 1").email("abc1@gmail.com").build(),
            Customer.builder().id("002").name("Live Code 2").email("abc2@gmail.com").build(),
            Customer.builder().id("002").name("Live Code 2").email("abc2@gmail.com").build()
    );

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();

        if (customers.size() == 0) {
            throw new CustomerNotFoundException();
        } else if (customers.size() > 1) {
            throw new DuplicationCustomerRecordsException();
        }
        return ResponseEntity.ok(customers.get(0));
    }

    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<ErrorResponse> handleCustomerAlreadyExistsException(ApplicationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getMessage());
        return ResponseEntity.status(ex.getHtpStatusCode()).body(errorResponse);
    }
}
