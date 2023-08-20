package com.data.KafkaMongoDbImp.service;


import com.data.KafkaMongoDbImp.model.Customer;
import com.data.KafkaMongoDbImp.repository.CustomerRepo;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }



    public boolean existsById(long id) {
        return customerRepo.existsById(id);
    }

    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }

//    public List<Customer> getData() {
//        return customerRepo.findAll();
//    }

    public List<Customer> getData() {
        return customerRepo.findAll();
    }

//    public Optional<Customer> findById(Long id) {
//        return customerRepo.findById(id);
//    }

        public Optional updateCustomer(Long id, Customer updatedCustomer) throws ResourceNotFoundException {
            Optional<Customer> optionalCustomer = customerRepo.findById(id);
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                customer.setFirstName(updatedCustomer.getFirstName());
                customer.setLastName(updatedCustomer.getLastName());
                customer.setAmountPaid(updatedCustomer.getAmountPaid());

                return Optional.of(customerRepo.save(customer));
            }
            return Optional.empty();

        }}


//    public Optional<Customer> findById(Long id) {
//        return  customerRepo.findById(id);
//    }


