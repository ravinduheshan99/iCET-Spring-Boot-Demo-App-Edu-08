package edu.icet.crm.service;

import edu.icet.crm.model.Customer;

import java.util.Optional;

public interface CustomerService {
    public Optional<Customer> retrieveCustomerByName(String name);
}
