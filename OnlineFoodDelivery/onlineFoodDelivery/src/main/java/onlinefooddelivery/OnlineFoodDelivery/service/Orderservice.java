package onlinefooddelivery.OnlineFoodDelivery.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.OrderDAO;
import onlinefooddelivery.OnlineFoodDelivery.DAO.UserDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;
import onlinefooddelivery.OnlineFoodDelivery.Entity.User;

@Service
public class Orderservice {
	@Autowired
	private UserDAO userdao;
	private OrderDAO orderdao;
	
	public Order placeOrder(int id) {
		User user=userdao.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		
		Order order=new Order();
		order.setUser(user);
		order.setOrderTime(LocalDateTime.now());
		order.setStatus("PLACED");
		
		return orderdao.save(order);
	}
	
	public List<Order> getOrderByUser(int id){
		return orderdao.findById(id);
	}
	

}
