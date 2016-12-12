package data.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.access.TruckDAO;
import domain.Car;
import domain.Truck;

public class TruckDS implements TruckDAO {

	@Override
	public void add(Truck truck) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO vehicle(rentPrice, rented, modelNo, make, number, color, type) values ('%d', '%d', '%d', '%d', '%d', '%s', '%s');",
				truck.getRentPrice(), truck.getRented(), truck.getModelNo(), truck.getMake(), truck.getNumber(),
				truck.getColor(), "truck");
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Truck truck) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("DELETE FROM vechicle WHERE numnber = %d;", truck.getNumber());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Truck car) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Truck> getTrucks() {
		List<Truck> trucks = new ArrayList<>();
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select * from vehicle where type = '%s'", "Truck");
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Truck truck = Truck.getInstance();
				truck.setColor(rs.getString("color"));
				truck.setMake(rs.getInt("make"));
				truck.setModelNo(rs.getInt("modelNo"));
				truck.setNumber(rs.getInt("regNo"));
				truck.setRented(rs.getInt("rented"));
				truck.setRentPrice(rs.getInt("rentPrice"));
				trucks.add(truck);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trucks;
	}
	
	@Override
	public List<Truck> getTrucksForCustomer() {
		List<Truck> trucks = new ArrayList<>();
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select * from vehicle where type = '%s' AND status = 0", "Truck");
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Truck truck = Truck.getInstance();
				truck.setColor(rs.getString("color"));
				truck.setMake(rs.getInt("make"));
				truck.setModelNo(rs.getInt("modelNo"));
				truck.setNumber(rs.getInt("regNo"));
				truck.setRented(rs.getInt("rented"));
				truck.setRentPrice(rs.getInt("rentPrice"));
				trucks.add(truck);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trucks;
	}

}
