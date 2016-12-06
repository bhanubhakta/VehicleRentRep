package data.access;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.Vehicle;

public interface CarDAO {
	public void add(Car car);

	public void delete(Car car);

	public void update(Car car);

	public List<Car> getCars();
	
//	public List<Car> cars = new ArrayList<>();
//	public List<Car> rCars = new ArrayList<>();
}
