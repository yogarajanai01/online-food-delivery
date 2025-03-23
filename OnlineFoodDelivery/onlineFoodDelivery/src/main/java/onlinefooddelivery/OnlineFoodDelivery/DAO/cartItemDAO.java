package onlinefooddelivery.OnlineFoodDelivery.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.CartItem;

@Repository
public interface cartItemDAO extends JpaRepository<CartItem, Integer>{
	List<CartItem>findByUserId(int userId);
}
