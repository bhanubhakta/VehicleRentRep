package data.access;

import java.util.List;

import domain.Customer;

public interface CustomerDAO {
	public void create(Customer customer);

	public void delete(Customer customer);

	public void update(Customer customer);

	public List<Customer> getCustomers();
}
