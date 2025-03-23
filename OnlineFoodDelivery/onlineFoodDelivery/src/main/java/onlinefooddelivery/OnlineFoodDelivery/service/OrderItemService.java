package onlinefooddelivery.OnlineFoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.OrderItemDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;
import onlinefooddelivery.OnlineFoodDelivery.Entity.OrderItem;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemDAO orderItemdao;
	
	public void addItemsToOrder(Order order,List<OrderItem> items) {
		for(OrderItem item:items) {
			item.setOrder(order);
			orderItemdao.save(item);
		}
	}

}
