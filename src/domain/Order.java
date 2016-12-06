package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private long startDate;
	private long endDate;
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
}
