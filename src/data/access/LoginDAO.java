package data.access;

import domain.LoginManager;

public interface LoginDAO {
	public boolean isValidUser(LoginManager lManager);
}
