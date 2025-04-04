package onlinefooddelivery.OnlineFoodDelivery.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
     
	List<Order> findById(int id);
}