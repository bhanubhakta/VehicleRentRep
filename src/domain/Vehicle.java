package domain;

public abstract class Vehicle {
	private Insurance insurance;
	private int rentPrice;
	protected int rented;

	public abstract boolean isRented(Vehicle v);

	public Insurance getInsurance() {
		return insurance;
	}

	public int getRentPrice() {
		return rentPrice;
	}
}
