package onlinefooddelivery.OnlineFoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefooddelivery.OnlineFoodDelivery.DAO.cartItemDAO;
import onlinefooddelivery.OnlineFoodDelivery.Entity.CartItem;

@Service
public class cartService {
	@Autowired
	private cartItemDAO cartitemdao;
	
	public CartItem addtoCart(CartItem cartitem) {
		return cartitemdao.save(cartitem);
	}

	public List<CartItem>getCartItemsByUser(int UserId){
		return cartitemdao.findByUserId(UserId);
	}
	public void removeCartItem(int cartItemId) {
		cartitemdao.deleteById(cartItemId);
	}
}
