package data.access;

import domain.Order;
import domain.Payment;

public interface PaymentDAO {
	public void create(Order order, Payment payment);
}
