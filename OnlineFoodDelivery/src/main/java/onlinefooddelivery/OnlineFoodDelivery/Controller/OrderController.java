package onlinefooddelivery.OnlineFoodDelivery.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;
import onlinefooddelivery.OnlineFoodDelivery.DAO.UserDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.OrderItem;
import onlinefooddelivery.OnlineFoodDelivery.Entity.User;
import onlinefooddelivery.OnlineFoodDelivery.Service.OrderItemService;
import onlinefooddelivery.OnlineFoodDelivery.Service.OrderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired private OrderItemService orderItemService;
	@Autowired private UserDAO userdao;
	
	@PostMapping("/order/{userId}")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId,@RequestBody List<OrderItem> items)
	{
		User user =userdao.findById(userId).orElseThrow();
		
		Order order=new Order();
		order.setUser(user);
		order.setMenuNames(null);
		order.setTotalprice(null);
		order.setPaymentMethod(null);
		order.setOrderDateTime(LocalDateTime.now());
		orderService.save(order);
		
		for(OrderItem item: items) {
			item.setOrder(order);
			orderItemService.save(item);
		}
		return ResponseEntity.ok("Order placed Successfully");
		
	}
	
	@GetMapping ("/order/{userId}")
	public List<Order> getOrdersByUser(@PathVariable Long userId){
		return orderService.findByUserId(userId);
		
	}

}
