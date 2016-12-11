package domain;

public class Truck extends Vehicle {

	@Override
	public boolean isRented(Vehicle v) {
		// TODO Auto-generated method stub
		return rented == 1;
	}

	private Truck() {

	}

	public static Truck getInstance() {
		return new Truck();
	}
	
	public double getInsurancePrice(){
		return insurance.getPrice();
	}
}
