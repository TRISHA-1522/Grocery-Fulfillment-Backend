package com.grocery.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.grocery.orderservice.entity.Order;
import com.grocery.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public Order place(@RequestBody Order order){

        return service.placeOrder(order);

    }

    @GetMapping
    public List<Order> getOrders(){

        return service.getAllOrders();

    }

    @PutMapping("/{id}/{status}")
    public Order update(@PathVariable Long id,
                        @PathVariable String status){

        return service.updateStatus(id,status);

    }

}