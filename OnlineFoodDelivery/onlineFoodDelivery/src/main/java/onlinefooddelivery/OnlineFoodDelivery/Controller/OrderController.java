package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;
import onlinefooddelivery.OnlineFoodDelivery.Entity.OrderItem;
import onlinefooddelivery.OnlineFoodDelivery.service.OrderItemService;
import onlinefooddelivery.OnlineFoodDelivery.service.Orderservice;

@RestController
public class OrderController {
	@Autowired
	private Orderservice orderservice;
	private OrderItemService orderItemservice;
	
	@PostMapping("/getuser/{id}")
	public ResponseEntity<String> placeOrder(@PathVariable int id,@RequestBody List<OrderItem> items){
		Order order=orderservice.placeOrder(id);
		orderItemservice.addItemsToOrder(order, items);
		return ResponseEntity.ok("Order placed sucessfully!...");
		
	}
	
	@GetMapping("/getorder/{id}")
	public ResponseEntity<List<Order>> getOrderByUser(@PathVariable int id){
		List<Order> orders=orderservice.getOrderByUser(id);
		if(orders.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(orders);
		
	}
}
