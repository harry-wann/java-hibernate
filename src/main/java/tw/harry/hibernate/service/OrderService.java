package tw.harry.hibernate.service;

import java.util.List;

import tw.harry.hibernate.entity.Order;
import tw.harry.hibernate.entity.OrderItem;

public interface OrderService {
	Long createOrder(String customer);
	Long createOrderWithItems(String customer, List<OrderItem> items);
	void changeCustomer(Long id, String newName);
	void addItem(Long id, String pname, int price, int qty);
	void updateItemQty(Long orderId, Long itemId, int newQty);
	void removeItem(Long orderId, Long itemId);
	Order getOrderWithItems(Long orderId);
	void delOrder(Long orderId);
}
