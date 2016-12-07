package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PasswordController implements Initializable, ControlledScreen {

	ScreensController myController;

	// @FXML private TextField
	// firstNameText,lastNameText,phoneNumberText,addressText, emailText;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private void onCreatePassword(ActionEvent event) {
		myController.setScreen(ScreensFramework.customerDashboardID);
	}

	@FXML
	private void onCancel(ActionEvent event) {
		myController.setScreen(ScreensFramework.welcomeScreenID);
	}
}
