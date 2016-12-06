package domain;

import java.util.List;

public class Payment {
	private List<Order> orders;

	private Payment() {

	}

	public void setOrder(Order or) {
		this.orders.add(or);
	}

	public static Payment getInstance() {
		return new Payment();
	}

	public double calculateTotalPrice() {
		double totSum = 0;
		for (Order o : orders) {
			for (Vehicle v : o.getVehicles()) {
				totSum += v.getRentPrice() * (o.getEndDate() - o.getStartDate());
				totSum += v.getInsurance().getPrice();
			}
		}
		return totSum;
	}
}
