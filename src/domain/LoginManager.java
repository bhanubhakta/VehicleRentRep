package domain;

public class LoginManager {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	private LoginManager() {

	}

	public static LoginManager getInstance() {
		return new LoginManager();
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
