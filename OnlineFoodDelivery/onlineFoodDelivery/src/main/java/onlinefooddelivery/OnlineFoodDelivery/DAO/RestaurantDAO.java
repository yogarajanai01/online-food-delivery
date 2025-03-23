package onlinefooddelivery.OnlineFoodDelivery.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onlinefooddelivery.OnlineFoodDelivery.Entity.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer>{

}
