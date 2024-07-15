package edu.icet.crm.service.impl;

import edu.icet.crm.exception.CustomerNotFoundException;
import edu.icet.crm.exception.InvalidParameterException;
import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    public Optional<Customer> retrieveCustomerByName(String name) {

        if (!StringUtils.hasText(name)){
            throw new InvalidParameterException("Customer Name Not Provided");
        }

        /*
        Customer customer1 = new Customer();
        customer1.setName("Ravindu");
        customer1.setEmail("ravinduheshan99@gmail.com");
        customer1.setAge("24");
        customer1.setActive(false);

        Customer customer2 = new Customer("Yushmi","yush@gmail.com","24");

        //from builder annotation
        Customer.builder().name("Lakshani").email("shanifeb94@gmail.com").age("30").build();
        */

        Customer requiredCustomer = null;

        Customer customer1 = new Customer("Yushmi1", "yush1@gmail.com", "24");
        Customer customer2 = new Customer("Yushmi2", "yush2@gmail.com", "25");
        Customer customer3 = new Customer("Yushmi3", "yush3@gmail.com", "26");

        /*
        //normal method
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        */

        List<Customer> customerList = List.of(customer1, customer2, customer3);


        for(Customer customer:customerList){
            //constant first object secod method to avoid nullpointer exceptions
            // don't use if(customer.getName().equalsIgnoreCase("Yushmi2"))
            //insted of using equals() we can use equalsIgnoreCase to avoid case sensitivity when check the condition
            if(name.equalsIgnoreCase(customer.getName())){
                requiredCustomer=customer;
            }
        }

        /*
        //ParallelStream is ok for the filtering but not recommended for using for update object values due to it's thread unsafetyness
        Optional<Customer> firstOccurence = customerList.parallelStream()
                                            .filter(cust -> name.equalsIgnoreCase(cust.getName()))
                                            .findFirst();
        */

        /*
        Optional<Customer> firstOccurence = customerList.stream()
                                            .filter(cust -> name.equalsIgnoreCase(cust.getName()) && cust.isActive())
                                            .findFirst();
        */

        if (requiredCustomer==null){
            throw new CustomerNotFoundException(String.format("%s Customer Not Found",name));
        }
        return Optional.ofNullable(requiredCustomer);
    }
}
