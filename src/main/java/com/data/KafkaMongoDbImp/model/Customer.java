package com.data.KafkaMongoDbImp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CustomerDetails")
public class Customer {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Float amountPaid;


}
