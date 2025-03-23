package onlinefooddelivery.OnlineFoodDelivery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.OrderItemDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.OrderItem;
@Service
public class OrderItemService {
	@Autowired 
	private OrderItemDAO orderItemdao;


	public OrderItem save(OrderItem item) {
		return orderItemdao.save(item);
		
		
	}

}
