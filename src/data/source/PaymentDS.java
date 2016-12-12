package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.PaymentDAO;
import domain.Order;
import domain.Payment;

public class PaymentDS implements PaymentDAO {

	@Override
	public boolean create(Integer orderId, Integer amount, Integer vehicleRegNo, Integer accountNumber){
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Payments(orderID, amount, accountNo) values ('%d', '%d', '%d');", orderId, amount, accountNumber);
		
		String sqlVehicleStatusUpdate = String.format(
				"UPDATE Vehicle SET rented = 1 where regNo = '%d'", vehicleRegNo);
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sqlVehicleStatusUpdate);
			System.out.println("Payment Made!!");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
