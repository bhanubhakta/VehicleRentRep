
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;
import javax.xml.ws.soap.AddressingFeature;

import data.access.CarDAO;
import data.access.CustomerDAO;
import data.access.InsuranceDAO;
import data.access.TruckDAO;
import data.access.VehicleDAO;
import data.source.CarDS;
import data.source.CustomerDS;
import data.source.InsuranceDS;
import data.source.TruckDS;
import data.source.VehicleDS;
import domain.Car;
import domain.Customer;
import domain.Insurance;
import domain.Truck;
import domain.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class AdminDashboardController implements Initializable, ControlledScreen {

	ScreensController myController;
	CustomerDAO customer;
	CarDAO car;
	TruckDAO truck;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
		customer = new CustomerDS();
	}

	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private ListView<String> vehicleList;

	@FXML
	private Pane AddVehiclePane, CarListPane, TruckListPane;
	@FXML
	private TextField makeText, modelText, numberText, colorText, rentPriceText, insuranceText;

	@FXML
	private TableView<Car> VehicleListTable;

	@FXML
	private TableView<Truck> TruckListTable;

	@FXML
	private TableColumn<Car, String> regNoColCar, makeColCar, modelNoColCar, colorColCar, rentedColCar, rentPriceColCar, insuranceAmountColCar;

	@FXML
	private TableColumn<Truck, String> regNoColTruck, makeColTruck, modelNoColTruck, colorColTruck, rentedColTruck, insuranceAmountColTruck,
			rentPriceColTruck;

	@FXML
	private ComboBox<String> vehicleTypeCmb;

	@FXML
	private void logoutClick(ActionEvent event) {
		System.out.println("logout");
		myController.setScreen(ScreensFramework.welcomeScreenID);
	}

	@FXML
	private void OnAddVehicleBtn(ActionEvent event) {
		AddVehiclePane.setVisible(true);
		CarListPane.setVisible(false);
		TruckListPane.setVisible(false);

	}

	@FXML
	private void OnAddVehicleClick(ActionEvent event) {

		VehicleDAO vehicle = new VehicleDS();
		InsuranceDAO insuranceDAO = new InsuranceDS();
		Insurance insurance = new Insurance();
		insurance.setPrice(Integer.parseInt(insuranceText.getText()));
		Vehicle v = Car.getInstance();
		v.setMake(Integer.parseInt(makeText.getText()));
		v.setModelNo(Integer.parseInt(modelText.getText()));
		v.setNumber(Integer.parseInt(numberText.getText()));
		v.setColor(colorText.getText());
		v.setRentPrice(Integer.parseInt(rentPriceText.getText()));
		v.setRented(0);
		v.setStatus(0);
		v.setType(vehicleTypeCmb.getValue());
		v.setInsurance(insurance);

		vehicle.create(v);
		insuranceDAO.create(insurance, v.getNumber());
		AddVehiclePane.setVisible(false);

	}

	@FXML
	private void OnCancelVehicleClick(ActionEvent event) {

		AddVehiclePane.setVisible(false);

	}

	@FXML
	private void OnViewTruckListClick(ActionEvent event) {
		CarListPane.setVisible(false);
		TruckListPane.setVisible(true);
		regNoColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("number"));
		makeColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("make"));
		modelNoColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("modelNo"));
		colorColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("color"));
		rentPriceColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("rentPrice"));
		rentedColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("rented"));
		List<Truck> listVehicles = new ArrayList<>();
		truck = new TruckDS();
		listVehicles = truck.getTrucks();

		TruckListTable.setItems(FXCollections.observableArrayList(listVehicles));
	
		}

	@FXML
	private void OnViewCarListClick(ActionEvent event) {

		TruckListPane.setVisible(false);
		CarListPane.setVisible(true);
		regNoColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("number"));
		makeColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
		modelNoColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("modelNo"));
		colorColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("color"));
		rentPriceColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("rentPrice"));
		rentedColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("rented"));
//		insuranceAmountColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("insurancePrice"));

		List<Car> listVehicles = new ArrayList<>();
		car = new CarDS();
		listVehicles = car.getCars();

		VehicleListTable.setItems(FXCollections.observableArrayList(listVehicles));

	}

	// section Customer
	@FXML
	private TableView<Customer> CustomerListTable;

	@FXML
	private TableColumn<Customer, String> lastNameCol, firstNameCol, addressCol, phoneCol, emailCol;

	@FXML
	private void OnViewCustomerBtnClicked(ActionEvent event) {

		CustomerListTable.setVisible(true);
		List<Customer> customerList = new ArrayList<>();
		customer = new CustomerDS();
		customerList = customer.getCustomers();
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
		addressCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNo"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
		CustomerListTable.setItems(FXCollections.observableArrayList(customerList));

	}

}
