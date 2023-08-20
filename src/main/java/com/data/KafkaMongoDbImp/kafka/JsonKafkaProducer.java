package com.data.KafkaMongoDbImp.kafka;

import com.data.KafkaMongoDbImp.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate <String, Customer> kafkaTemplate;
    public void sendMessage(Customer data) {

        Message<Customer> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "Record")
                .build();
        kafkaTemplate.send(message);

        LOGGER.info(String.format("Message sent %s", data));

    }

}
