package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.InsuranceDAO;
import domain.Insurance;

public class InsuranceDS implements InsuranceDAO{

	@Override
	public void create(Insurance in, int vehicleRegNumber) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO Insurance(price, vehicleRegNo) values ('%d', '%d');", in.getPrice(), vehicleRegNumber);
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Insurance in) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Insurance in) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Insurance getInsurance() {
		// TODO Auto-generated method stub
		return null;
	}

}
