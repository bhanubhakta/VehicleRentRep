package data.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.access.CustomerDAO;
import domain.Customer;
import domain.Order;
import domain.Payment;

public class CustomerDS implements CustomerDAO {

	@Override
	public void create(Customer customer) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Users(firstName, LastName, Address, Phone) values ('%s', '%s', '%s', '%d', '%d', '%d');",
				customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNo());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Customer customer) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("DELETE FROM customer WHERE email = %d;", customer.getEmail());
		try {
			st = connection.createStatement();
			st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select * from Customer");
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer customer = Customer.getInstance();
				customer.setEmail(rs.getString("email"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("address"));
				customer.setPhoneNo(rs.getInt("phoneNo"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	public List<Order> getOrders(Customer customer) {
		return customer.orders;
	}

	public List<Payment> getPayments(Customer customer) {
		return customer.payments;
	}

}