package onlinefooddelivery.OnlineFoodDelivery.DAO;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;
@Repository
public interface MenuItemDAO extends JpaRepository<MenuItem, Integer>{

	List<MenuItem> findByRestaurantId(int restaurantId);

	Optional<MenuItem> findById(int id);

	
}
