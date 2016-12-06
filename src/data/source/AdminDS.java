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
				"INSERT INTO user(firstName, LastName, Address, Phone, email) values ('%s', '%s', '%s', '%d', '%s');",
				admin.getFirstName(), admin.getLastName(), admin.getAddress(), admin.getPhoneNo(), admin.getEmail());
		try {
			st = connection.createStatement();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
