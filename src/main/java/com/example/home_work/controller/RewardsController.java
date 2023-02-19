package com.example.home_work.controller;

import com.example.home_work.entity.Customer;
import com.example.home_work.entity.Rewards;
import com.example.home_work.repository.CustomerRepository;
import com.example.home_work.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class RewardsController {

    RewardsService rewardsService;

    CustomerRepository customerRepository;
    @Autowired
    RewardsController(RewardsService rewardsService,CustomerRepository customerRepository){
        this.rewardsService = rewardsService;
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/{customerId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Integer customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null) throw new RuntimeException("the customer is not exist!");

        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards,HttpStatus.OK);
    }

}
