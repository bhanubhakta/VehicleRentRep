package domain;

public abstract class Vehicle {
	protected Insurance insurance;
	private int rentPrice;
	protected int rented;
	protected int modelNo;
	protected int make;
	protected int number;
	protected String color;
	protected int status;
	protected String type;
	//protected double insurancePrice;
	
		
	public int getRented() {
		return rented;
	}

	public int getModelNo() {
		return modelNo;
	}

	public int getMake() {
		return make;
	}

	public int getNumber() {
		return number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public void setRented(int rented) {
		this.rented = rented;
	}

	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}

	public void setMake(int make) {
		this.make = make;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract boolean isRented(Vehicle v);

	public Insurance getInsurance() {
		return insurance;
	}
	
	//public abstract double getInsurancePrice();

	public int getRentPrice() {
		return rentPrice;
	}
	

//	public void setInsurancePrice(double price) {
//		insurancePrice = price;
//	}
}
