package onlinefooddelivery.OnlineFoodDelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_items")
public class CartItem {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "menu_item_id")
	    private MenuItem menuItem;

	    private int quantity;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public MenuItem getMenuItem() {
			return menuItem;
		}

		public void setMenuItem(MenuItem menuItem) {
			this.menuItem = menuItem;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public CartItem() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CartItem(int id, MenuItem menuItem, int quantity, User user) {
			super();
			this.id = id;
			this.menuItem = menuItem;
			this.quantity = quantity;
			this.user = user;
		}

		@Override
		public String toString() {
			return "CartItem [id=" + id + ", menuItem=" + menuItem + ", quantity=" + quantity + ", user=" + user + "]";
		}
	    
	    
}
