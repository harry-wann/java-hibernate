package tw.harry.hibernate.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.harry.hibernate.dao.OrderDao;
import tw.harry.hibernate.dao.OrderDaoImpl;
import tw.harry.hibernate.entity.Order;
import tw.harry.hibernate.entity.OrderItem;
import tw.harry.hibernate.util.HibernateUtil;

public class OrderServiceImpl implements OrderService {

	@Override
	public Long createOrder(String customer) {

		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setOdate(LocalDate.now());
			
			OrderDao dao = new OrderDaoImpl();
			
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();

			System.out.println("WTF createOrder");
			return order.getId();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
		
		return -1L;
	}

	@Override
	public Long createOrderWithItems(String customer, List<OrderItem> items) {

		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setOdate(LocalDate.now());
			order.setItems(items);
			
			OrderDao dao = new OrderDaoImpl();
			
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();

			System.out.println("WTF createOrder");
			return order.getId();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
		
		return -1L;
	}

	@Override
	public void changeCustomer(Long id, String newName) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = session.find(Order.class, id);
			order.setCustomer(newName);
			
			OrderDao dao = new OrderDaoImpl();
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}

	@Override
	public void addItem(Long id, String pname, int price, int qty) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = session.find(Order.class, id);
			OrderItem item = new OrderItem(pname, price, qty);
			order.addItem(item);
			
			OrderDao dao = new OrderDaoImpl();
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}

	@Override
	public void updateItemQty(Long orderId, Long itemId, int newQty) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = session.find(Order.class, orderId);
			Optional<OrderItem> item = order.getItems().stream()
						.filter((i) -> i.getId() == itemId)
						.findFirst();
			item.get().setQty(newQty);
			
			OrderDao dao = new OrderDaoImpl();
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}

	@Override
	public void removeItem(Long orderId, Long itemId) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = session.find(Order.class, orderId);
			Optional<OrderItem> item = order.getItems().stream()
						.filter((i) -> i.getId() == itemId)
						.findFirst();
			order.removeItem(item.get());
			
			OrderDao dao = new OrderDaoImpl();
			ts = session.beginTransaction();
			dao.save(session, order);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}

	@Override
	public Order getOrderWithItems(Long orderId) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			OrderDao dao = new OrderDaoImpl();
			Optional<Order> order = dao.findById(session, orderId);
			return order.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delOrder(Long orderId) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			Order order = session.find(Order.class, orderId);
			OrderDao dao = new OrderDaoImpl();
			ts = session.beginTransaction();
			dao.delete(session, order);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}

}
