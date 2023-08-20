package com.data.KafkaMongoDbImp.repository;

import com.data.KafkaMongoDbImp.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository <Customer, Long> {


}
