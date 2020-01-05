package com.example.accessingdatajpa.controller;

import cn.hutool.core.util.StrUtil;
import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * test sayHello
     * @param who
     * @return
     */
    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }

    /**
     * 插入数据
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping(value = "/insert")
    public boolean insert(String firstName, String lastName){
        try {
            if (!StrUtil.isBlank(firstName) || !StrUtil.isBlank(lastName)) {
                repository.save(new Customer(firstName, lastName));
            } else {
                repository.save(new Customer("Jason","Statham"));
                repository.save(new Customer("Audrey","Hepburn"));
                repository.save(new Customer("John","Rambo"));
                repository.save(new Customer("Sylvester","Stallone"));
                repository.save(new Customer("Tom","Cruise"));
            }

            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询所有 Customer
     * @return
     */
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

    /**
     * 根据 lastName 查询 Customer
     * @param lastName
     * @return
     */
    @RequestMapping(value = "/findByLastName")
    public List<Customer> findByLastName(String lastName){
        if (StrUtil.isBlank(lastName)){
            lastName = "Stallone";
        }

        ArrayList<Customer> customers = new ArrayList<>();
        repository.findByLastName(lastName).forEach(stallone -> {
            customers.add(stallone);
        });

        return customers;
    }

    /**
     * 根据 lastName 过滤 Customer，并修改其 firstName
     * @param lastName
     * @param firstName
     * @return
     */
    @RequestMapping(value = "update")
    public String update(String lastName,String firstName){
        if (!StrUtil.isBlank(lastName) && !StrUtil.isBlank(firstName)) {
            findByLastName(lastName).forEach(byLastName ->{
                byLastName.setFirstName(firstName);
                repository.save(byLastName);
            });
//            repository.findByLastName(lastName).forEach(byLastName ->{
//                byLastName.setFirstName(firstName);
//                repository.save(byLastName);
//            });
            return "Success!";
        } else {
            ;
            return "Please enter lastName and firstName!";
        }
    }

    /**
     * 根据 lastName 过滤并删除
     * @param lastName
     * @return
     */
    @RequestMapping(value = "delete")
    public String delete(String lastName){
        if (!StrUtil.isBlank(lastName)) {
            List<Customer> byLastName = findByLastName(lastName);
            if (byLastName.isEmpty()){
                return "No customer's lastName is " + lastName ;
            } else {
                for(Customer customer : byLastName){
                    repository.delete(customer);
                }
            }
//            findByLastName(lastName).forEach(byLastName ->{
//                repository.delete(byLastName);
//            });
            return "Success!";
        } else {
            return "Please enter lastName!";
        }
    }
}
