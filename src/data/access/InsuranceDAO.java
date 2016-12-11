package data.access;

import domain.Insurance;


public interface InsuranceDAO {
	
	public void create(Insurance in, int vehicleRegNumber);

	public void update(Insurance in);

	public void delete(Insurance in);

	public Insurance getInsurance();

}
