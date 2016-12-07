package data.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import data.access.LoginDAO;
import domain.LoginManager;

public class LoginDS implements LoginDAO {

	@Override
	public boolean isValidUser(LoginManager lManager) {
		boolean validUser = false;
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select email, password from Users where email = '%s'", lManager.getUserName());
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("password").equals(lManager.getPassword())) {
					validUser = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return validUser;
	}

	public boolean isAdmin(LoginManager lManager) {
		DBConnection dc = new DBConnection();
		DBConnection.loadDriver();
		Connection connection = dc.getConnection();
		Statement st = null;
		String sql = String.format("select isAdmin from Users where email = '%s'", lManager.getUserName());
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getInt("isAdmin") == 1) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
