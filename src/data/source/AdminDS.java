package data.source;

import java.sql.Connection;
import java.sql.Statement;

import data.access.AdminDAO;
import domain.Admin;

public class AdminDS implements AdminDAO {

	@Override
	public void create(Admin admin) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format(
				"INSERT INTO user(firstName, LastName, Address, Phone, email, isAdmin) values ('%s', '%s', '%s', '%d', '%s', '%d');",
				admin.getFirstName(), admin.getLastName(), admin.getAddress(), admin.getPhoneNo(), admin.getEmail(), 1);
		try {
			st = connection.createStatement();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
