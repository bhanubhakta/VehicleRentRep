package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import data.access.OrderDAO;

public class Customer extends Person implements Serializable {

	private Customer() {

	}

	public static Customer getInstance() {
		return new Customer();
	}

	public List<Order> orders = new ArrayList<>();
	public List<Payment> payments = new ArrayList<>();

	public Order makeOrder(Vehicle vehicle) {
		Order order = Order.getInstance();
		this.orders.add(order);
		order.addVehicle(vehicle);
		order.setStatus(1);
		return order;
	}

	public Payment makePayment(Order order) {
		order.setStatus(2);
		Payment payment = Payment.getInstance();
		payment.setOrder(order);
		return payment;
	}

}
