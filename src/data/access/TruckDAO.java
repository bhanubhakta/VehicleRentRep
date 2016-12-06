package data.access;

import java.util.ArrayList;
import java.util.List;

import domain.Truck;

public interface TruckDAO {

	public void add(Truck truck);

	public void delete(Truck car);

	public void update(Truck car);

	public List<Truck> cars = new ArrayList<>();
	public List<Truck> rCars = new ArrayList<>();
}
