package data.access;

import domain.Order;
import domain.Payment;

public interface PaymentDAO {
	public boolean create(Integer orderId, Integer amount, Integer vehicleRegNo,  Integer accountNumber);
}
