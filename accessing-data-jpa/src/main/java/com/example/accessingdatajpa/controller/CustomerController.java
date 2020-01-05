package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>FileName: CustomerController</p>
 * <p>Description: </p>
 * <p>Email: zhangwb-s@qq.com</p>
 *
 * @author harper
 * @version 0.1.0
 * @date 2020.01.05
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/insert")
    public boolean insert(){
        try {
            repository.save(new Customer("Jason","Statham"));
            repository.save(new Customer("Audrey","Hepburn"));
            repository.save(new Customer("John","Rambo"));
            repository.save(new Customer("Sylvester","Stallone"));
            repository.save(new Customer("Tom","Cruise"));

            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "findAll")
    public List<Customer> findAll(){
        ArrayList<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customer -> {
            customers.add(customer);
        });
//        for (Customer customer : repository.findAll()){
//            customers.add(customer);
//        }
        return customers;
    }

    @RequestMapping(value = "/findByLastName")
    public List<Customer> findByLastName(){
        String lastName = "Stallone";
        ArrayList<Customer> customers = new ArrayList<>();
        repository.findByLastName(lastName).forEach(stallone -> {
            customers.add(stallone);
        });
        return customers;
    }
}
