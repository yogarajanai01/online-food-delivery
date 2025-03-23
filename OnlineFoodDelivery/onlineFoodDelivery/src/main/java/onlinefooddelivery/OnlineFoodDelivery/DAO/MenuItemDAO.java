package onlinefooddelivery.OnlineFoodDelivery.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.MenuItem;

@Repository
public interface MenuItemDAO extends JpaRepository<MenuItem, Integer> {
	//get restaurant using id
	  List<MenuItem> findByRestaurantId(int id);

	 
	  

}
