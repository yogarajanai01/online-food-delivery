package onlinefooddelivery.OnlineFoodDelivery.Entity;

import java.util.List;

public class OrderRequest {
	 private List<Integer> menuItemIds;
	    private String paymentMethod;

	    // Getters and Setters
	    public List<Integer> getMenuItemIds() {
	        return menuItemIds;
	    }

	    public void setMenuItemIds(List<Integer> menuItemIds) {
	        this.menuItemIds = menuItemIds;
	    }

	    public String getPaymentMethod() {
	        return paymentMethod;
	    }

	    public void setPaymentMethod(String paymentMethod) {
	        this.paymentMethod = paymentMethod;
}

}