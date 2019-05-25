package com.spring.spingboot_order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spingboot_order.dao.OrderDAO;
import com.spring.spingboot_order.model.Order;

@RestController
@RequestMapping("/buyer")
public class OrderController {
	
	@Autowired
	OrderDAO orderDAO;
	
	/*Save an order*/
	@PostMapping("/orders")
	public Order createOrder(@Valid @RequestBody Order ord) {
		return orderDAO.save(ord);
	}
	
	/*Get all Orders*/
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderDAO.findAll();
	}
	
	/*Get Order by Id*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value="id") Long ordid){
		Order ord = orderDAO.findOne(ordid);
		
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ord);
	}
	
	/*Update order by order ID*/
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value="id") Long ordid, @Valid @RequestBody Order ordDetails){
		Order ord = orderDAO.findOne(ordid);
		
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		
		ord.setPrice(ordDetails.getPrice());
		ord.setQty(ordDetails.getQty());
		ord.setBuyerAddress(ordDetails.getBuyerAddress());
		
		Order updateOrder = orderDAO.save(ord);
		
		return ResponseEntity.ok().body(updateOrder);
	}
	
	/*Delete an Order*/
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable(value="id") Long ordid){
		Order ord = orderDAO.findOne(ordid);
		
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		
		orderDAO.delete(ord);
		
		return ResponseEntity.ok().build();
	}
	
	
}
