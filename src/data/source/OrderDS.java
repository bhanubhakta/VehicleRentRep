package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.OrderDAO;
import domain.Customer;
import domain.Order;
import domain.Vehicle;

public class OrderDS implements OrderDAO {

	@Override
	public void create(Customer customer, Order order, Vehicle vehicle) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Orders(customerEmail, startDate, endDate, status, vehicleNo) values ('%s', '%d', '%d', '%d', '%d');",
				customer.getEmail(), order.getStartDate(), order.getEndDate(), order.getStatus(), vehicle.getNumber());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
