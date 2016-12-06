package data.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.access.CarDAO;
import domain.Car;
import domain.Customer;
import domain.Insurance;

public class CarDS implements CarDAO {

	@Override
	public void add(Car car) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO vehicle(rentPrice, rented, modelNo, make, number, color, type) values ('%d', '%d', '%d', '%d', '%d', '%s', '%s');",
				car.getRentPrice(), car.getRented(), car.getModelNo(), car.getMake(), car.getNumber(), car.getColor(),
				"car");
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Car car) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("DELETE FROM car WHERE numnber = %d;", car.getNumber());
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<>();
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select * from vehicle");
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Car car = Car.getInstance();
				car.setColor(rs.getString("color"));
				car.setMake(rs.getInt("make"));
				car.setModelNo(rs.getInt("modelNo"));
				car.setNumber(rs.getInt("number"));
				car.setRented(rs.getInt("rented"));
				car.setRentPrice(rs.getInt("rentPrice"));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

}
