/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import data.access.CarDAO;
import data.access.OrderDAO;
import data.access.TruckDAO;
import data.access.VehicleDAO;
import data.source.CarDS;
import data.source.OrderDS;
import data.source.TruckDS;
import data.source.VehicleDS;
import domain.Car;
import domain.Order;
import domain.Truck;
import domain.Vehicle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class CustomerDashboardController implements Initializable, ControlledScreen {

	ScreensController myController;
	CarDAO car;
	OrderDAO order;
	TruckDAO truck;
	
	@FXML
	private Pane TruckPane, CarPane, VehicleAnchorPane, OrderPane;
	
	@FXML
	private TableView<Vehicle> TruckListTable;
	
	@FXML
	private TableView<Vehicle> CarListTable;

	@FXML
	private TableColumn<Car, String> regNoColCar, makeColCar, modelNoColCar, colorColCar, rentedColCar, rentPriceColCar, insuranceAmountColCar;

	@FXML
	private TableColumn<Truck, String> regNoColTruck, makeColTruck, modelNoColTruck, colorColTruck, rentedColTruck, insuranceAmountColTruck,
			rentPriceColTruck;

	@FXML
	private Button OrderBtn, OrderCarBtn, OrderTruckBtn, ConfirmOrderBtn;
	
	@FXML
	private Label labelMake, labelModel, labelRegNumber, labelColor, LabelPricePerHour, TotalPricelabel;
	
	@FXML
	private ComboBox<String> dayFromCmb, monthFromCmb, yearFromCmb, dayToCmb, monthToCmb, yearToCmb;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}

	@FXML
	private void goToScreen1(ActionEvent event) {
		myController.setScreen(ScreensFramework.registrationScreenID);
	}

	@FXML
	private void logoutClick(ActionEvent event) {
		System.out.println("logout");
		myController.setScreen(ScreensFramework.welcomeScreenID);
	}
	
	
	@FXML
	private void OnViewTruckBtn(ActionEvent event) {
		
		CarPane.setVisible(false);
		OrderPane.setVisible(false);
		OrderCarBtn.setVisible(false);
		OrderTruckBtn.setVisible(true);
		List<Truck> listVehicles = new ArrayList<>();
		truck = new TruckDS();
		listVehicles = truck.getTrucks();
		
		if(listVehicles.size()>0){
			TruckPane.setVisible(true);			
			regNoColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("number"));
			makeColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("make"));
			modelNoColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("modelNo"));
			colorColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("color"));
			rentPriceColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("rentPrice"));
			rentedColTruck.setCellValueFactory(new PropertyValueFactory<Truck, String>("rented"));
			TruckListTable.setItems(FXCollections.observableArrayList(listVehicles));
		}
		
	}
	
	@FXML
	private void OnViewCarBtn(ActionEvent event) {
		
		TruckPane.setVisible(false);
		OrderPane.setVisible(false);
		OrderCarBtn.setVisible(true);
		OrderTruckBtn.setVisible(false);		
		List<Car> listVehicles = new ArrayList<>();
		car = new CarDS();
		listVehicles = car.getCars();
		
		if(listVehicles.size()>0){			
			CarPane.setVisible(true);
			regNoColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("number"));
			makeColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
			modelNoColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("modelNo"));
			colorColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("color"));
			rentPriceColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("rentPrice"));
			rentedColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("rented"));
//			insuranceAmountColCar.setCellValueFactory(new PropertyValueFactory<Car, String>("insurancePrice"));

			CarListTable.setItems(FXCollections.observableArrayList(listVehicles));
			
		}
		
//		CarListTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//		    if (newSelection != null) {
//		    	OrderBtn.setDisable(false);
//		    	System.out.println(CarListTable.getSelectionModel().getSelectedItem().getNumber());
//		    }
//		});	
		
	}
	
	@FXML
	private void OnCarOrderClick(ActionEvent event) {
		CarPane.setVisible(false);
		TruckPane.setVisible(false);
		OrderPane.setVisible(true);
		labelMake.setText(String.valueOf(CarListTable.getSelectionModel().getSelectedItem().getMake()));
		labelModel.setText(String.valueOf(CarListTable.getSelectionModel().getSelectedItem().getModelNo()));
		labelRegNumber.setText(String.valueOf(CarListTable.getSelectionModel().getSelectedItem().getNumber()));
		labelColor.setText(String.valueOf(CarListTable.getSelectionModel().getSelectedItem().getColor()));
		LabelPricePerHour.setText(String.valueOf(CarListTable.getSelectionModel().getSelectedItem().getRentPrice()));
		
	}
	
	@FXML
	private void OnTruckOrderClick(ActionEvent event) {
		TruckPane.setVisible(false);
		CarPane.setVisible(false);
		OrderPane.setVisible(true);
		labelMake.setText(String.valueOf(TruckListTable.getSelectionModel().getSelectedItem().getMake()));
		labelModel.setText(String.valueOf(TruckListTable.getSelectionModel().getSelectedItem().getModelNo()));
		labelRegNumber.setText(String.valueOf(TruckListTable.getSelectionModel().getSelectedItem().getNumber()));
		labelColor.setText(String.valueOf(TruckListTable.getSelectionModel().getSelectedItem().getColor()));
		LabelPricePerHour.setText(String.valueOf(TruckListTable.getSelectionModel().getSelectedItem().getRentPrice()));
		
	}
	
	
	@FXML
	private void OnShowPriceBtnClick(ActionEvent event) throws ParseException {
		String to = dayToCmb.getValue() + " " + monthToCmb.getValue() + " " + yearToCmb.getValue();
		String from = dayFromCmb.getValue() + " " + monthFromCmb.getValue() + " " + yearFromCmb.getValue();
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Date date1 = new Date();
		Date date2 = new Date();
		int diffInDays = 0;
		try {
		    date1 = myFormat.parse(from);
		    date2 = myFormat.parse(to); 
		    diffInDays = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
		    System.out.println(diffInDays);
		} catch (ParseException e) {
		    e.printStackTrace();
		}		
		
		TotalPricelabel.setText(String.valueOf(diffInDays * Integer.parseInt(LabelPricePerHour.getText())));
		if(Integer.parseInt(TotalPricelabel.getText()) > 0)
			ConfirmOrderBtn.setVisible(true);
	}
	
	
	@FXML
	private void OnConfirmOrderClick(ActionEvent event) throws ParseException {
		
		String to = dayToCmb.getValue() + " " + monthToCmb.getValue() + " " + yearToCmb.getValue();
		String from = dayFromCmb.getValue() + " " + monthFromCmb.getValue() + " " + yearFromCmb.getValue();
		
		
//		String inputString1 = "23 01 1997";
//		String inputString2 = "27 01 1997";
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		 Date date1 = new Date();
		 Date date2 = new Date();

		try {
		    date1 = myFormat.parse(from);
		    date2 = myFormat.parse(to); 
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	
		order = new OrderDS();
		
		Order o = new Order();
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		o.setStartDate(d1);
		o.setEndDate(d2);
		o.setStatus(1);
		
		List<String> customerData = new ArrayList<String>();
		customerData = myController.getDataListReceived();		

		order.create(customerData.get(0),o , CarListTable.getSelectionModel().getSelectedItem().getNumber());
		
	}
	
	
	@FXML
	private void OnCancelOrder(ActionEvent event){
		OrderPane.setVisible(false);
	}
	
}
