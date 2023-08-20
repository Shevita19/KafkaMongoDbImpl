package com.data.KafkaMongoDbImp.kafka;

import com.data.KafkaMongoDbImp.model.Customer;
import com.data.KafkaMongoDbImp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "Record", groupId = "myGroup")
    public void consume(Customer customer) {

        LOGGER.info(String.format("Json Message received %s", customer));

        boolean isExistingCustomer = customerService.existsById(customer.getId());

        if (!isExistingCustomer) {
            customerService.save(customer);
            LOGGER.info("Customer saved in the database.");
        } else {
            long id = customer.getId();
            customer.setId(id);
            customerService.save(customer);
            LOGGER.info("Customer updated in the database.");
        }
    }
}
