package data.source;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import data.access.VehicleDAO;
import domain.Vehicle;

public class VehicleDS implements VehicleDAO{

	@Override
	public void create(Vehicle v) {
		// TODO Auto-generated method stub
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO vehicle(make, modelNo, regNo, color, rented, price) values ('%d', '%d', '%d', '%s', '%d', '%d');",
				v.getMake(), v.getModelNo(), v.getNumber(), v.getColor(), v.getRented(), v.getRentPrice());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehicle> getVehicles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
