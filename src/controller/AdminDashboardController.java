
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import data.access.CustomerDAO;
import data.source.CustomerDS;
import domain.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;


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
    
    
}
