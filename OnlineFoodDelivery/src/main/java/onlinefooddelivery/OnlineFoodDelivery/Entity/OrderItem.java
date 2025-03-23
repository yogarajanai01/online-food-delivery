package onlinefooddelivery.OnlineFoodDelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

@Entity
@Table (name="OrderItems")
public class OrderItem {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull  (message="Quantity is mondatory")
	private int quantity;
	@ManyToOne
	@JoinColumn (name="order_id")
	private Order order;
	@ManyToOne
	@JoinColumn (name="menuitem_id")
	private MenuItem menuItem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	public OrderItem(Long id, @NotNull(message = "Quantity is mondatory") int quantity, Order order,
			MenuItem menuItem) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.menuItem = menuItem;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", order=" + order + ", menuItem=" + menuItem + "]";
	}
	
	

}
