package com.data.KafkaMongoDbImp.controller;

import com.data.KafkaMongoDbImp.kafka.JsonKafkaProducer;
import com.data.KafkaMongoDbImp.model.Customer;
import com.data.KafkaMongoDbImp.repository.CustomerRepo;
import com.data.KafkaMongoDbImp.service.CustomerService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    private CustomerService customerService;

    @PostMapping("saveData")
    public ResponseEntity<String> saveData(@RequestBody Customer customer){
        jsonKafkaProducer.sendMessage(customer);
        return  ResponseEntity.ok("Json Message send to kafka topic");

    }



    @GetMapping("/getValue")
    public List<Customer> getCustomerData(){

        return customerService.getData();
    }





    @DeleteMapping("/deleteData/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Long id) throws ResourceNotFoundException{
        customerService.deleteById(id);
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for the id ::" + id));


        String responseMessage = "Customer record with ID " + id + " is deleted";

        return  ResponseEntity.ok(responseMessage);

    }


//    //http://localhost:8080/auth/updateData/1
//    @PutMapping("/updateData/{id}")
//    public ResponseEntity <Customer> updateEmployee (@PathVariable(value= "id") Long id,
//                                                     @Valid @RequestBody Customer updatedCustomer)
//            throws ResourceNotFoundException{
//        Customer customer = customerService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for the id ::" + id));
//
//        customer.setFirstName(updatedCustomer.getFirstName());
//        customer.setLastName(updatedCustomer.getLastName());
//        final Customer updatedEmployee = customerService.save(customer);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//

    @PutMapping("/updateData/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody Customer updatedCustomer) {
            Optional<Customer> optionalCustomer = customerService.updateCustomer(id, updatedCustomer);

            return optionalCustomer.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }




}
