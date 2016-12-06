package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

	private Customer() {

	}

	public static Customer getInstance() {
		return new Customer();
	}

	public List<Order> orders = new ArrayList<>();
	public List<Payment> payments = new ArrayList<>();

}
