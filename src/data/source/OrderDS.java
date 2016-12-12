package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.OrderDAO;
import domain.Customer;
import domain.Order;
import domain.Vehicle;

public class OrderDS implements OrderDAO {

	@Override
	public void create(String customerUserName, Order order, Integer vehicle) {
		System.out.println(vehicle);
		System.out.println(customerUserName);
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Orders(customerEmail, startDate, endDate, status, vehicleNo) values ('%s', '%d', '%d', '%d', '%d');",
				customerUserName, order.getStartDate(), order.getEndDate(), order.getStatus(), vehicle);
		
		String sqlVehicleStatusUpdate = String.format(
				"UPDATE Vehicle SET status = '%d' where regNo = '%d'",
				order.getStatus(), vehicle);
		
	
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sqlVehicleStatusUpdate);
			 System.out.println("ohhhmBhrimSankateMamaRogamNashayaSwaha!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
