package data.access;

import java.util.ArrayList;
import java.util.List;

import domain.Vehicle;

public interface VehicleDAO {
	public void create(Vehicle v);

	public void update(Vehicle v);

	public void delete(Vehicle v);

	public List<Vehicle> vehicles = new ArrayList<>();
	
	public List<Vehicle> rVehicles = new ArrayList<>();
}
