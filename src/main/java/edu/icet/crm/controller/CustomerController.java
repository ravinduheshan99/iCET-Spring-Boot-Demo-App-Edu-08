package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.SuccessResponse;
import edu.icet.crm.service.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    //global scope
    //dependent variable
    //if object is assigning automatically by the spring frame work means dependency injection-@autowired
    //why we make this variable as a final?
    private final CustomerService customerService;

    //local scope
    @GetMapping("/get/{name}")
    public ResponseEntity<SuccessResponse> retrieveCustomerByName(@PathVariable String name, HttpServletRequest request){

        //Access the custom headers and default headers from a network request
        String header = request.getHeader("user-id");
        String host = request.getHeader("HOST");
        String incomingIpAddress = request.getHeader("Origin");

        Optional<Customer> optionalCustomer = customerService.retrieveCustomerByName(name);

        if (!optionalCustomer.isPresent()){
            return null;
        }

        Customer customer = optionalCustomer.get();
        log.info("Response {}",customer.getName());
        SuccessResponse success = SuccessResponse.builder()
                .status("Success")
                .data(customer).build();
        return ResponseEntity.ok().body(success);
    }
}
