package factories;

import domain.Order;
import domain.Payment;

public class OrderPaymentImpl {
	private Order or;
	private Payment p;

	public OrderPaymentImpl(Order order, Payment payment) {
		this.or = order;
		this.p = payment;
	}
}
