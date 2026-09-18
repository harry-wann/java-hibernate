package tw.harry.hibernate.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.entity.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Long save(Session session, Order order) {
		session.persist(order);
		System.out.println("WTF persist");
		return order.getId();
	}

	@Override
	public Optional<Order> findById(Session session, Long id) {
		return Optional.ofNullable(session.find(Order.class, id));
	}

	@Override
	public Optional<Order> findByIdWithItems(Session session, Long id) {
		String hql = """
			SELECT O
			FROM Order O
			LEFT JOIN FETCH O.items
			WHERE O.id = :id
		""";
		Order order = session.createQuery(hql, Order.class)
				.setParameter("id", id)
				.getSingleResult();
		return Optional.ofNullable(order);
	}

	@Override
	public void delete(Session session, Order order) {
		session.remove(order);
	}

	@Override
	public List<Order> findAll(Session session, int start, int size) {
		String hql = """
			SELECT O
			FROM Order O
			ORDER BY o.id ASC
		""";
		return session.createQuery(hql, Order.class)
			.setFirstResult(start)
			.setMaxResults(size)
			.list();
	}

	public List<Order> findByCustomer(Session session, String customer) {
		String hql = """
			SELECT O
			FROM Order O
			WHERE O.customer = :cname
		""";
		return session.createQuery(hql, Order.class)
			.setParameter("cname", customer)
			.list();
	}
	
	public List<Order> findByODate(Session session) {
		String hql = """
			SELECT O
			FROM Order O
			ORDER BY o.odate ASC
		""";
		return session.createQuery(hql, Order.class)
			.list();
	}
	
	public List<Order> findByPName(Session session, String pname) {
		String hql = """
			SELECT O
			FROM Order O
			JOIN FETCH O.items OIT
			WHERE OIT.pname = :pname
			ORDER BY o.odate ASC
		""";
		return session.createQuery(hql, Order.class)
			.setParameter("pname", pname)
			.list();
	}
}
