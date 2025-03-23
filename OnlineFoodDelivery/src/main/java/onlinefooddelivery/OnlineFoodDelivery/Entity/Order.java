package onlinefooddelivery.OnlineFoodDelivery.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table(name="`Orders`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;

	private String menuNames;
	
	private Double Totalprice;
	
	private String paymentMethod;
	
	private LocalDateTime orderDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMenuNames() {
		return menuNames;
	}

	public void setMenuNames(String menuNames) {
		this.menuNames = menuNames;
	}

	public Double getTotalprice() {
		return Totalprice;
	}

	public void setTotalprice(Double totalprice) {
		Totalprice = totalprice;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, User user, String menuNames, Double totalprice, String paymentMethod,
			LocalDateTime orderDateTime) {
		super();
		this.id = id;
		this.user = user;
		this.menuNames = menuNames;
		Totalprice = totalprice;
		this.paymentMethod = paymentMethod;
		this.orderDateTime = orderDateTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", menuNames=" + menuNames + ", Totalprice=" + Totalprice
				+ ", paymentMethod=" + paymentMethod + ", orderDateTime=" + orderDateTime + "]";
	}

	
}
