package domain;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private long startDate;
	private long endDate;

	private SecureRandom random = new SecureRandom();
	// Status can be free, booked and rented
	private int status;
	private List<Vehicle> vehicles = new ArrayList<>();

	public Order() {

	}

	public static Order getInstance() {
		return new Order();
	}

	public long getStartDate() {
		return startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void makeOrder(Vehicle vehicle) {
		this.status = 1;
		this.vehicles.add(vehicle);
	}

	public void makePayment(Payment p) {
		this.status = 2;
		p.addOrder(this);
	}

	public String generateID() {
		return new BigInteger(130, random).toString(32);
	}
}
