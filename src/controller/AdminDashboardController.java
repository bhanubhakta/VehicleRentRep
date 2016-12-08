
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.xml.ws.soap.AddressingFeature;

import data.access.CustomerDAO;
import data.access.VehicleDAO;
import data.source.CustomerDS;
import data.source.VehicleDS;
import domain.Car;
import domain.Customer;
import domain.Insurance;
import domain.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class AdminDashboardController implements Initializable , ControlledScreen {

    ScreensController myController;
    CustomerDAO customers;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	customers = new CustomerDS();
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private  ListView<String> vehicleList;
    
    @FXML
    private Pane AddVehiclePane;
    @FXML
    private TextField makeText, modelText, numberText, colorText, rentPriceText, insuranceText;

    @FXML
    private void onClickCar(ActionEvent event){
    
      System.out.println("Car is clicked");
      
      }
      
    
    @FXML
    private void onClickTruck(ActionEvent event){
      System.out.println("Car is clicked");
    }
    
    @FXML
    private void onClickBus(ActionEvent event){
      System.out.println("Car is clicked");
    }
    
    @FXML
    private void logoutClick(ActionEvent event){
    	System.out.println("logout");
       myController.setScreen(ScreensFramework.welcomeScreenID);
    }
    
    @FXML
    private void onClickViewCustomers(ActionEvent event){
    	System.out.println("Customer");
    	List<Customer> customerList = new ArrayList<>();
        customerList = customers.getCustomers();
    }   
    
    
    @FXML
    private void OnAddVehicleBtn(ActionEvent event){
    	AddVehiclePane.setVisible(true);
    }
    
    @FXML
    private void OnAddVehicleClick(ActionEvent event){
    	 
    	
    	VehicleDAO vehicle = new VehicleDS();
    	Insurance insurance = new Insurance();
    	insurance.setPrice(Integer.parseInt(insuranceText.getText()));
    	Vehicle v = Car.getInstance();
    	v.setMake(Integer.parseInt(makeText.getText()));
    	v.setModelNo(Integer.parseInt(modelText.getText()));
    	v.setNumber(Integer.parseInt(numberText.getText()));
    	v.setColor(colorText.getText());
    	v.setRentPrice(Integer.parseInt(rentPriceText.getText()));
    	v.setRented(0);
    	v.setInsurance(insurance);
    	vehicle.create(v); 	   
    	AddVehiclePane.setVisible(false);
    	
    }
    
    @FXML
    private void OnCancelVehicleClick(ActionEvent event){    	 
    	
    	AddVehiclePane.setVisible(false);    	
    	
    	
    }
    
    
    
    
}
