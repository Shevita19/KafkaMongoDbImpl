//package com.data.KafkaMongoDbImp.controller;
//
//
//import com.data.KafkaMongoDbImp.kafka.KafkaProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/auth")
//public class CustomerController {

//    @Autowired
//    private CustomerService customerService;
//
//
//    @GetMapping("/getData")
//    public List <Customer> getCustomerData(){
//        return  customerService.getCustomerData();
//
//    }
//
//
//    @PostMapping("/saveData")
//    public Customer saveCustomerData(@RequestBody Customer customer){
//        return customerService.saveData(customer);
//
//    }
//


//    @Autowired
//    private KafkaProducer kafkaProducer;
//
//
//    //localhost:8080/auth/getData?message=helloooooo
//
//    @GetMapping("getData")
//    public ResponseEntity<String> getData(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
//        return  ResponseEntity.ok("Message send to topic");
//
//    }
//
//
//



