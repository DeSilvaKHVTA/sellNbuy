package com.spring.spingboot_order.repository;

import com.spring.spingboot_order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
