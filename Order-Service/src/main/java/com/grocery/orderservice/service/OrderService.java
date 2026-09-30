package com.grocery.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.orderservice.entity.Order;
import com.grocery.orderservice.repopsitory.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public Order placeOrder(Order order){

        order.setStatus("PLACED");

        return repo.save(order);

    }

    public List<Order> getAllOrders(){

        return repo.findAll();

    }

    public Order updateStatus(Long id,String status){

        Order order=repo.findById(id).orElse(null);

        if(order!=null){

            order.setStatus(status);

            return repo.save(order);

        }

        return null;

    }

}