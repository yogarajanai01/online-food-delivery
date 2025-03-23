package onlinefooddelivery.OnlineFoodDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.OrderDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;
@Service 
public class OrderService {
	@Autowired 
	private OrderDAO orderdao;

	 public Order save(Order order) {
	        return orderdao.save(order);  // Save order to the database
	    }

	public List<Order> findByUserId(Long userId) {
		
		return orderdao.findByUserId(userId);
	}
	
}
