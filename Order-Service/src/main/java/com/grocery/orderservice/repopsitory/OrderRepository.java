package com.grocery.orderservice.repopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grocery.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}