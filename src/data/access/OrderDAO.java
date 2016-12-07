package data.access;

import domain.Customer;
import domain.Order;
import domain.Vehicle;

public interface OrderDAO {
	public void create(Customer customer, Order order, Vehicle vehicle);
	// public void create(Customer c, List<Vehicle> vehicles);
}
