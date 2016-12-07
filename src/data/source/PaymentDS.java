package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.PaymentDAO;
import domain.Order;
import domain.Payment;

public class PaymentDS implements PaymentDAO {

	@Override
	public void create(Order order, Payment payment) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Payments(orderID) values ('%s');", order.generateID());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
