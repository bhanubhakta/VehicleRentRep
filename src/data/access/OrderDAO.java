package data.access;

import domain.Customer;
import domain.Order;
import domain.Vehicle;

public interface OrderDAO {
	public int create(String customerUserName, Order order, Integer vehicle);
	// public void create(Customer c, List<Vehicle> vehicles);
}
