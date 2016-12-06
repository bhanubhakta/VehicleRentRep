package domain;

public class Car extends Vehicle {

	@Override
	public boolean isRented(Vehicle v) {
		return v.rented == 1;
	}

}
