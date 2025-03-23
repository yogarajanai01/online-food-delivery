package onlinefooddelivery.OnlineFoodDelivery.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.OrderItem;
@Repository 
public interface OrderItemDAO extends JpaRepository<OrderItem, Long>{

}
