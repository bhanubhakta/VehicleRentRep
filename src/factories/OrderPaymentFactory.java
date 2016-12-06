package factories;

import domain.Order;
import domain.Payment;

public class OrderPaymentFactory {
	public OrderPaymentImpl OrderPaymentFactory(double price) {
		Order od = Order.getInstance();
		Payment p = Payment.getInstance();
		p.setOrder(od);
		return new OrderPaymentImpl(od, p);
	}
}
