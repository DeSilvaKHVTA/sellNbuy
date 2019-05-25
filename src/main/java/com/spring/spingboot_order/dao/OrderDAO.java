package com.spring.spingboot_order.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spingboot_order.model.Order;
import com.spring.spingboot_order.repository.OrderRepository;

@Service
public class OrderDAO {
	
	@Autowired
	OrderRepository orderRepository;
	
	/*To save an order*/	
	public Order save(Order ord) {
		return orderRepository.save(ord);
	}

	/*Search all orders*/
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	/*Get an order by ID*/
	public Order findOne(long ordid) {
		return orderRepository.findById(ordid).orElse(null);
	}
	
	/*Delete an order*/
	public void delete(Order ord) {
		orderRepository.delete(ord);
	}
}
